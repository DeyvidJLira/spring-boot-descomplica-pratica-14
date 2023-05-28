package com.deyvidjlira.atividade_pratica_14.service;

import com.deyvidjlira.atividade_pratica_14.entitiy.Usuario;
import com.deyvidjlira.atividade_pratica_14.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repository;

    public List<Usuario> getAll(){
        return repository.findAll();
    }

    public Usuario getById(Integer id) {
        return repository.findById(id).orElse(null) ;
    }

    public Usuario findByEmail(String email){
        return repository.findByEmail(email).get();
    }

    public Usuario saveUsuario(Usuario element) {
        return repository.save(element);
    }

    public Usuario updateUsuario(Integer id, Usuario element) {
        Usuario elementUpdated = repository.findById(id).orElse(null);
        if(elementUpdated != null) {
            elementUpdated.setNome(element.getNome());
            return repository.save(elementUpdated);
        }else {
            return null;
        }
    }

    public Boolean deleteUser(Integer id) {
        Usuario element = repository.findById(id).orElse(null);
        if(element != null) {
            repository.delete(element);
            return true;
        }else {
            return false;
        }
    }
}
