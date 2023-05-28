package com.deyvidjlira.atividade_pratica_14.service;

import com.deyvidjlira.atividade_pratica_14.entitiy.Projeto;
import com.deyvidjlira.atividade_pratica_14.entitiy.Recurso;
import com.deyvidjlira.atividade_pratica_14.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoService {

    @Autowired
    RecursoRepository repository;

    public List<Recurso> getAll(){ return repository.findAll(); }

    public Recurso getById(Integer id) { return repository.findById(id).orElse(null) ; }

    public Recurso saveRecurso(Recurso element) { return repository.save(element); }

    public Recurso updateRecurso(Integer id, Recurso element) {
        Recurso elementUpdated = repository.findById(id).orElse(null);
        if(elementUpdated != null) {
            elementUpdated.setFuncao(element.getFuncao());
            elementUpdated.setNome(element.getNome());
            return repository.save(elementUpdated);
        }else {
            return null;
        }
    }

    public Boolean deleteRecurso(Integer id) {
        Recurso element = repository.findById(id).orElse(null);
        if(element != null) {
            repository.delete(element);
            return true;
        }else {
            return false;
        }
    }

    public Recurso getByNome(String nome) {
        return repository.findByNome(nome).orElse(null) ;
    }
}
