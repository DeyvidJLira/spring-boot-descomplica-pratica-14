package com.deyvidjlira.atividade_pratica_14.security;

import com.deyvidjlira.atividade_pratica_14.entitiy.Usuario;
import com.deyvidjlira.atividade_pratica_14.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
public class UsuarioDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuarioFounded = repository.findByEmail(email);
        if(usuarioFounded.isEmpty())
            throw new UsernameNotFoundException("Não foi possível encontrar usuário com o email = " + email);

        Usuario usuario = usuarioFounded.get();
        return new org.springframework.security.core.userdetails.User(
                email,
                usuario.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}