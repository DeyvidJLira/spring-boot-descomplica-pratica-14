package com.deyvidjlira.atividade_pratica_14.repository;

import com.deyvidjlira.atividade_pratica_14.entitiy.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {
    Optional<Projeto> findByDescricao(String descricao);
}
