package br.edu.ifpr.receitas.controller;
import br.edu.ifpr.receitas.model.Receita;
import br.edu.ifpr.receitas.model.ReceitaApi;
import br.edu.ifpr.receitas.repository.ReceitaRepository;
import br.edu.ifpr.receitas.service.ReceitaApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReceitaController {

    private final ReceitaRepository repository;
    private final ReceitaApiService apiService;

    public ReceitaController(ReceitaRepository repository, ReceitaApiService apiService) {
        this.repository = repository;
        this.apiService = apiService;
    }

    @GetMapping("/")
    public String inicio() {
        return "index";
    }

    @GetMapping("/receitas")
    public String listar(Model model) {
        model.addAttribute("receitas", repository.findAll());
        return "receitas";
    }

    @GetMapping("/receitas/nova")
    public String novaReceita(Model model) {
        model.addAttribute("receita", new Receita());
        return "formulario";
    }

    @PostMapping("/receitas/salvar")
    public String salvar(@ModelAttribute Receita receita) {
        repository.save(receita);
        return "redirect:/receitas";
    }

    @GetMapping("/receitas/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Receita receita = repository.findById(id).orElseThrow();
        model.addAttribute("receita", receita);
        return "formulario";
    }

    @GetMapping("/receitas/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/receitas";
    }

    @GetMapping("/buscar")
    public String buscarReceita(@RequestParam String nome, Model model) {

        ReceitaApi receita = apiService.buscarReceita(nome);

        model.addAttribute("receita", receita);
        model.addAttribute("nomeBusca", nome);

        return "busca";
    }
}