package com.deyvidjlira.atividade_pratica_14.service;

import com.deyvidjlira.atividade_pratica_14.entitiy.ProjetoStatus;
import com.deyvidjlira.atividade_pratica_14.repository.ProjetoStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoStatusService {

    @Autowired
    ProjetoStatusRepository repository;

    public List<ProjetoStatus> getAll(){
        return repository.findAll();
    }

    public ProjetoStatus getById(Integer id) {
        return repository.findById(id).orElse(null) ;
    }

    public ProjetoStatus saveProjetoStatus(ProjetoStatus element) {
        return repository.save(element);
    }

    public ProjetoStatus updateProjetoStatus(Integer id, ProjetoStatus element) {
        ProjetoStatus elementUpdated = repository.findById(id).orElse(null);
        if(elementUpdated != null) {
            elementUpdated.setNome(element.getNome());
            return repository.save(elementUpdated);
        }else {
            return null;
        }
    }

    public Boolean deleteProjetoStatus(Integer id) {
        ProjetoStatus element = repository.findById(id).orElse(null);
        if(element != null) {
            repository.delete(element);
            return true;
        }else {
            return false;
        }
    }
}
