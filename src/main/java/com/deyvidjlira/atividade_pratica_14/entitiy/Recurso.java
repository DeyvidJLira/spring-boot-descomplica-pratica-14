package com.deyvidjlira.atividade_pratica_14.entitiy;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "recurso")
public class Recurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recurso_id")
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "funcao", nullable = false)
    private String funcao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

}
