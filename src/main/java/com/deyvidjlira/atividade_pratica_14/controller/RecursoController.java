package com.deyvidjlira.atividade_pratica_14.controller;

import com.deyvidjlira.atividade_pratica_14.entitiy.Projeto;
import com.deyvidjlira.atividade_pratica_14.entitiy.Recurso;
import com.deyvidjlira.atividade_pratica_14.service.ProjetoService;
import com.deyvidjlira.atividade_pratica_14.service.RecursoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recurso")
@Tag(name="5. Recurso endpoints")
public class RecursoController {

    @Autowired
    RecursoService service;

    @GetMapping
    public ResponseEntity<List<Recurso>> getAll(){
        List<Recurso> items = service.getAll();
        if(!items.isEmpty())
            return new ResponseEntity<>(items, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recurso> getById(@PathVariable Integer id) {
        Recurso item = service.getById(id);
        if(item != null)
            return new ResponseEntity<>(item, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Recurso> save(@RequestBody Recurso item) {
        return new ResponseEntity<>(service.saveRecurso(item), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recurso> update(@PathVariable Integer id, @RequestBody Recurso item) {
        Recurso itemUpdated = service.updateRecurso(id, item);
        if(itemUpdated != null)
            return new ResponseEntity<>(itemUpdated, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        if(service.deleteRecurso(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.OK);
    }

    @GetMapping("/search-by-nome/{nome}")
    public ResponseEntity<Recurso> getByNome(@PathVariable String nome) {
        Recurso item = service.getByNome(nome);
        if(item != null)
            return new ResponseEntity<>(item, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
