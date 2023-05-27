package com.deyvidjlira.atividade_pratica_14.service;

import com.deyvidjlira.atividade_pratica_14.entitiy.Tarefa;
import com.deyvidjlira.atividade_pratica_14.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    TarefaRepository repository;

    public List<Tarefa> getAll(){
        return repository.findAll();
    }

    public Tarefa getById(Integer id) {
        return repository.findById(id).orElse(null) ;
    }

    public Tarefa saveTarefa(Tarefa element) {
        return repository.save(element);
    }

    public Tarefa updateTarefa(Integer id, Tarefa element) {
        Tarefa elementUpdated = repository.findById(id).orElse(null);
        if(elementUpdated != null) {
            elementUpdated.setNome(element.getNome());
            elementUpdated.setDescricao(element.getDescricao());
            elementUpdated.setStatus(element.getStatus());
            elementUpdated.setDataInicio(element.getDataInicio());
            elementUpdated.setDataFim(element.getDataFim());
            return repository.save(elementUpdated);
        }else {
            return null;
        }
    }

    public Boolean deleteTarefa(Integer id) {
        Tarefa element = repository.findById(id).orElse(null);
        if(element != null) {
            repository.delete(element);
            return true;
        }else {
            return false;
        }
    }
}
