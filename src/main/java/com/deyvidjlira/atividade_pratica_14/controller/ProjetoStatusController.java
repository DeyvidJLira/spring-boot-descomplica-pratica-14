package com.deyvidjlira.atividade_pratica_14.controller;

import com.deyvidjlira.atividade_pratica_14.entitiy.ProjetoStatus;
import com.deyvidjlira.atividade_pratica_14.service.ProjetoStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projeto-status")
public class ProjetoStatusController {
    @Autowired
    ProjetoStatusService service;

    @GetMapping
    public ResponseEntity<List<ProjetoStatus>> getAll(){
        List<ProjetoStatus> projetoStatus = service.getAll();
        if(!projetoStatus.isEmpty())
            return new ResponseEntity<>(projetoStatus, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoStatus> getById(@PathVariable Integer id) {
        ProjetoStatus projetoStatus = service.getById(id);
        if(projetoStatus != null)
            return new ResponseEntity<>(projetoStatus, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ProjetoStatus> save(@RequestBody ProjetoStatus projetoStatus) {
        return new ResponseEntity<>(service.saveProjetoStatus(projetoStatus), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoStatus> update(@PathVariable Integer id, @RequestBody ProjetoStatus projetoStatus) {
        ProjetoStatus itemUpdated = service.updateProjetoStatus(id, projetoStatus);
        if(itemUpdated != null)
            return new ResponseEntity<>(itemUpdated, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        if(service.deleteProjetoStatus(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.OK);
    }
}