package com.deyvidjlira.atividade_pratica_14.service;

import com.deyvidjlira.atividade_pratica_14.entitiy.TarefaStatus;
import com.deyvidjlira.atividade_pratica_14.repository.TarefaStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaStatusService {

    @Autowired
    TarefaStatusRepository repository;

    public List<TarefaStatus> getAll(){
        return repository.findAll();
    }

    public TarefaStatus getById(Integer id) {
        return repository.findById(id).orElse(null) ;
    }

    public TarefaStatus saveTarefaStatus(TarefaStatus element) {
        return repository.save(element);
    }

    public TarefaStatus updateTarefaStatus(Integer id, TarefaStatus element) {
        TarefaStatus elementUpdated = repository.findById(id).orElse(null);
        if(elementUpdated != null) {
            elementUpdated.setNome(element.getNome());
            return repository.save(elementUpdated);
        }else {
            return null;
        }
    }

    public Boolean deleteTarefaStatus(Integer id) {
        TarefaStatus element = repository.findById(id).orElse(null);
        if(element != null) {
            repository.delete(element);
            return true;
        }else {
            return false;
        }
    }
}
