package br.edu.ifpr.receitas.service;

import br.edu.ifpr.receitas.model.ReceitaApi;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class ReceitaApiService {

    private final RestTemplate restTemplate = new RestTemplate();

    public ReceitaApi buscarReceita(String nome) {

        String url = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + nome;

        Map<String, Object> resposta =
                restTemplate.getForObject(url, Map.class);

        if (resposta == null || resposta.get("meals") == null) {
            return null;
        }

        var meals = (java.util.List<Map<String, Object>>) resposta.get("meals");
        Map<String, Object> meal = meals.get(0);

        ReceitaApi receita = new ReceitaApi();

        receita.setNome((String) meal.get("strMeal"));
        receita.setCategoria((String) meal.get("strCategory"));
        receita.setOrigem((String) meal.get("strArea"));
        receita.setImagem((String) meal.get("strMealThumb"));
        receita.setPreparo((String) meal.get("strInstructions"));

        StringBuilder ingredientes = new StringBuilder();

        for (int i = 1; i <= 20; i++) {

            Object ingrediente = meal.get("strIngredient" + i);
            Object medida = meal.get("strMeasure" + i);

            if (ingrediente != null && !ingrediente.toString().isBlank()) {
                ingredientes.append("- ")
                        .append(medida)
                        .append(" ")
                        .append(ingrediente)
                        .append("\n");
            }
        }

        receita.setIngredientes(ingredientes.toString());

        return receita;
    }
}