package com.deyvidjlira.atividade_pratica_14.controller;

import com.deyvidjlira.atividade_pratica_14.entitiy.Tarefa;
import com.deyvidjlira.atividade_pratica_14.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    TarefaService service;

    @GetMapping
    public ResponseEntity<List<Tarefa>> getAll(){
        List<Tarefa> items = service.getAll();
        if(!items.isEmpty())
            return new ResponseEntity<>(items, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> getById(@PathVariable Integer id) {
        Tarefa item = service.getById(id);
        if(item != null)
            return new ResponseEntity<>(item, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Tarefa> save(@RequestBody Tarefa item) {
        return new ResponseEntity<>(service.saveTarefa(item), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> update(@PathVariable Integer id, @RequestBody Tarefa item) {
        Tarefa itemUpdated = service.updateTarefa(id, item);
        if(itemUpdated != null)
            return new ResponseEntity<>(itemUpdated, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        if(service.deleteTarefa(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.OK);
    }

}
