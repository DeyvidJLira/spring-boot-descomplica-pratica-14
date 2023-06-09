package com.deyvidjlira.atividade_pratica_14.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.deyvidjlira.atividade_pratica_14.entitiy.Usuario;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    @Value("${jwt-secret}")
    private String secret;

    @Value("${jwt-subject}")
    private String subject;

    @Value("${jwt-company-project-name}")
    private String companyProjectName;

    public String generateToken(String email) throws IllegalArgumentException, JWTCreationException {
        return JWT.create()
                .withSubject(subject)
                .withClaim("email", email)
                .withIssuedAt(new Date())
                .withIssuer(companyProjectName)
                .sign(Algorithm.HMAC256(secret));
    }

    public String generateTokenWithUserData(Usuario usuario) throws IllegalArgumentException, JWTCreationException {
        ObjectMapper mapper = new ObjectMapper();
        String userJson = null;
        try {
            userJson = mapper.writeValueAsString(usuario);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return JWT.create()
                .withSubject(subject)
                .withClaim("usuario", userJson)
                .withIssuedAt(new Date())
                .withIssuer(companyProjectName)
                .sign(Algorithm.HMAC256(secret));
    }

    public String validateTokenAndRetrieveSubject(String token) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withSubject(subject)
                .withIssuer(companyProjectName)
                .build();
        DecodedJWT jwt = verifier.verify(token);

        Usuario usuario = new Usuario();
        try {
            usuario = mapper.readValue(jwt.getClaim("usuario").asString(), Usuario.class);
        } catch (JsonProcessingException e) {
            throw new Exception("Ocorreu um erro e nao foi possivel converter o usario a partir da string json - " + e);
        }

        return usuario.getEmail();
    }

}