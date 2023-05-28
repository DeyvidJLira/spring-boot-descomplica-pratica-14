package com.deyvidjlira.atividade_pratica_14.repository;

import com.deyvidjlira.atividade_pratica_14.entitiy.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
}
