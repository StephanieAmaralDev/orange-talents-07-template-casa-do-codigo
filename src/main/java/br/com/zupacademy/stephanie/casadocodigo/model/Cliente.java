package br.com.zupacademy.stephanie.casadocodigo.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
    public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String documento;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Column(nullable = false)
    private String sobrenome;

    @NotBlank
    @Column(nullable = false)
    private String endereco;

    @NotBlank
    @Column(nullable = false)
    private String complemento;

    @NotBlank
    @Column(nullable = false)
    private String cidade;

    @NotBlank
    @Column(nullable = false)
    private String cep;

    @NotBlank
    @Column(nullable = false)
    private String telefone;

    @NotNull
    @ManyToOne
    @JoinColumn(nullable = false)
    private Pais pais;

    @ManyToOne
    private Estado estado;

    @Deprecated
    public Cliente() {
    }

    public Cliente(Long id, String email, String nome, String sobrenome, String documento, String endereco,
                   String complemento, String cidade, Pais pais, String cep, String telefone) {
        this.id = id;
        this.email = email;
        this.documento = documento;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.cep = cep;
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(email, cliente.email) && Objects.equals(documento, cliente.documento) && Objects.equals(nome, cliente.nome) && Objects.equals(sobrenome, cliente.sobrenome) && Objects.equals(endereco, cliente.endereco) && Objects.equals(complemento, cliente.complemento) && Objects.equals(cidade, cliente.cidade) && Objects.equals(cep, cliente.cep) && Objects.equals(telefone, cliente.telefone) && Objects.equals(pais, cliente.pais) && Objects.equals(estado, cliente.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, documento, nome, sobrenome, endereco, complemento, cidade, cep, telefone, pais, estado);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", documento='" + documento + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", cep='" + cep + '\'' +
                ", telefone='" + telefone + '\'' +
                ", pais=" + pais +
                ", estado=" + estado +
                '}';
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }
}

