package br.edu.ifpr.receitas.repository;

import br.edu.ifpr.receitas.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}