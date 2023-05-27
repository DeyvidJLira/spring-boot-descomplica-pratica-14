package com.deyvidjlira.atividade_pratica_14.entitiy;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "projeto_status")
public class ProjetoStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projeto_status_id")
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

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

}
