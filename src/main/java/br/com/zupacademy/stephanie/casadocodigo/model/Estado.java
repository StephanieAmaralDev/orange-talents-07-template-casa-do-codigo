package br.com.zupacademy.stephanie.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String nome;

    @ManyToOne
    @NotNull
    private Pais pais;

    public Estado() {}

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public boolean pertencePais(Pais pais) {
        return this.pais.equals(pais);
    }
}
