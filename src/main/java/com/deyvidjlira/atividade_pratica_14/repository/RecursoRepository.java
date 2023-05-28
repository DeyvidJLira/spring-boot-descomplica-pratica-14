package com.deyvidjlira.atividade_pratica_14.repository;

import com.deyvidjlira.atividade_pratica_14.entitiy.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecursoRepository extends JpaRepository<Recurso, Integer> {
    Optional<Recurso> findByNome(String nome);
}
