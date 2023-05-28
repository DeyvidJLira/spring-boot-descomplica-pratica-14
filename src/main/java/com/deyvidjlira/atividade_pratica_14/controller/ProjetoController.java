package com.deyvidjlira.atividade_pratica_14.controller;

import com.deyvidjlira.atividade_pratica_14.entitiy.Projeto;
import com.deyvidjlira.atividade_pratica_14.service.ProjetoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/projeto")
@Tag(name="3. Projeto endpoints")
public class ProjetoController {

    @Autowired
    ProjetoService service;

    @GetMapping
    public ResponseEntity<List<Projeto>> getAll(){
        List<Projeto> items = service.getAll();
        if(!items.isEmpty())
            return new ResponseEntity<>(items, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> getById(@PathVariable Integer id) {
        Projeto item = service.getById(id);
        if(item != null)
            return new ResponseEntity<>(item, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Projeto> save(@RequestBody Projeto item) {
        return new ResponseEntity<>(service.saveProjeto(item), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projeto> update(@PathVariable Integer id, @RequestBody Projeto item) {
        Projeto itemUpdated = service.updateProjeto(id, item);
        if(itemUpdated != null)
            return new ResponseEntity<>(itemUpdated, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        if(service.deleteProjeto(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.OK);
    }

    @GetMapping("/search-by-descricao/{descricao}")
    public ResponseEntity<Projeto> getByDescricao(@PathVariable String descricao) {
        Projeto item = service.getByDescricao(descricao);
        if(item != null)
            return new ResponseEntity<>(item, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
