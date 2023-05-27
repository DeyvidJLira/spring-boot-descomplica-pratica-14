package com.deyvidjlira.atividade_pratica_14.service;

import com.deyvidjlira.atividade_pratica_14.entitiy.Projeto;
import com.deyvidjlira.atividade_pratica_14.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    ProjetoRepository repository;

    public List<Projeto> getAll(){
        return repository.findAll();
    }

    public Projeto getById(Integer id) {
        return repository.findById(id).orElse(null) ;
    }

    public Projeto saveProjeto(Projeto element) {
        return repository.save(element);
    }

    public Projeto updateProjeto(Integer id, Projeto element) {
        Projeto elementUpdated = repository.findById(id).orElse(null);
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

    public Boolean deleteProjeto(Integer id) {
        Projeto element = repository.findById(id).orElse(null);
        if(element != null) {
            repository.delete(element);
            return true;
        }else {
            return false;
        }
    }
}
