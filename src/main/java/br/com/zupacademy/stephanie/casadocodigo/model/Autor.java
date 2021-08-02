package br.com.zupacademy.stephanie.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty (message = "O nome é obrigatório")
    private String nome;

    @Email
    @NotEmpty(message = "O email é obrigatório")
    private String email;

    @Size(max=400, message="Descrição deve ter no máximo {max} caracteres.")
    @NotEmpty(message = "A descrição é obrigatória")
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime instante = LocalDateTime.now();

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @Deprecated
    public Autor() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(id, autor.id) && Objects.equals(nome, autor.nome) && Objects.equals(email, autor.email) && Objects.equals(descricao, autor.descricao) && Objects.equals(instante, autor.instante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, descricao, instante);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public Long getId() {
        return id;
    }


}
