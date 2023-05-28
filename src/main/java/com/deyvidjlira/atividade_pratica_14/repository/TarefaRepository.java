package com.deyvidjlira.atividade_pratica_14.repository;

import com.deyvidjlira.atividade_pratica_14.entitiy.Tarefa;
import com.deyvidjlira.atividade_pratica_14.entitiy.TarefaStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
    Optional<Tarefa> findByStatus(TarefaStatus tarefaStatus);
}
