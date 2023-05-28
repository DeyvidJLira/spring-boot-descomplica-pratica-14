package com.deyvidjlira.atividade_pratica_14.controller;

import com.deyvidjlira.atividade_pratica_14.dto.UserCredentials;
import com.deyvidjlira.atividade_pratica_14.entitiy.Usuario;
import com.deyvidjlira.atividade_pratica_14.security.JWTUtil;
import com.deyvidjlira.atividade_pratica_14.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@Tag(name="1. Auth endpoints")
public class AuthController {
    @Autowired
    private UsuarioService service;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/registro")
    public Map<String, Object> registerHandler(@RequestBody Usuario usuario){
        String encodedPass = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(encodedPass);

        usuario = service.saveUsuario(usuario);

        Usuario usuarioPayload = new Usuario();
        usuarioPayload.setNome(usuarioPayload.getNome());
        usuarioPayload.setEmail(usuarioPayload.getEmail());
        usuarioPayload.setId(usuarioPayload.getId());

        String token = jwtUtil.generateTokenWithUserData(usuarioPayload);

        return Collections.singletonMap("jwt-token", token);
    }

    @PostMapping("/login")
    public Map<String, Object> loginHandler(@RequestBody UserCredentials body){
        try {
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(body.getEmail(), body.getPassword());

            authManager.authenticate(authInputToken);

            Usuario usuario = service.findByEmail(body.getEmail());
            Usuario usuarioPayload = new Usuario();
            usuarioPayload.setNome(usuario.getNome());
            usuarioPayload.setEmail(usuario.getEmail());
            usuarioPayload.setId(usuario.getId());

            String token = jwtUtil.generateTokenWithUserData(usuarioPayload);

            return Collections.singletonMap("jwt-token", token);
        }catch (AuthenticationException authExc){
            throw new RuntimeException("Credenciais Inválidas");
        }
    }
}
