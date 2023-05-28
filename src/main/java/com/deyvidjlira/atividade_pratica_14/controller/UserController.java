package com.deyvidjlira.atividade_pratica_14.controller;

import com.deyvidjlira.atividade_pratica_14.entitiy.Usuario;
import com.deyvidjlira.atividade_pratica_14.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UserController {
    @Autowired
    UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(){
        List<Usuario> items = service.getAll();
        if(!items.isEmpty())
            return new ResponseEntity<>(items, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Integer id) {
        Usuario item = service.getById(id);
        if(item != null)
            return new ResponseEntity<>(item, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/info")
    public Usuario getUserDetails(){
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return service.findByEmail(email);
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario item) {
        return new ResponseEntity<>(service.saveUsuario(item), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario item) {
        Usuario itemUpdated = service.updateUsuario(id, item);
        if(itemUpdated != null)
            return new ResponseEntity<>(itemUpdated, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        if(service.deleteUser(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        else
            return new ResponseEntity<>(false, HttpStatus.OK);
    }
}
