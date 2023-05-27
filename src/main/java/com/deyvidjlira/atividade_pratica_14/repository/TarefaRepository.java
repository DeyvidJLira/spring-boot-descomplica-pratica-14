package com.deyvidjlira.atividade_pratica_14.repository;

import com.deyvidjlira.atividade_pratica_14.entitiy.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
}
