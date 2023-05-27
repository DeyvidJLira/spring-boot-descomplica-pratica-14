package com.deyvidjlira.atividade_pratica_14.controller;

import com.deyvidjlira.atividade_pratica_14.entitiy.TarefaStatus;
import com.deyvidjlira.atividade_pratica_14.service.TarefaStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas-status")
public class TarefaStatusController {
    @Autowired
    TarefaStatusService service;

    @GetMapping
    public ResponseEntity<List<TarefaStatus>> getAll(){
        List<TarefaStatus> items = service.getAll();
        if(!items.isEmpty())
            return new ResponseEntity<>(items, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaStatus> getById(@PathVariable Integer id) {
        TarefaStatus item = service.getById(id);
        if(item != null)
            return new ResponseEntity<>(item, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<TarefaStatus> save(@RequestBody TarefaStatus item) {
        return new ResponseEntity<>(service.saveTarefaStatus(item), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaStatus> update(@PathVariable Integer id, @RequestBody TarefaStatus item) {
        TarefaStatus itemUpdated = service.updateTarefaStatus(id, item);
        if(itemUpdated != null)
            return new ResponseEntity<>(itemUpdated, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        if(service.deleteTarefaStatus(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.OK);
    }
}