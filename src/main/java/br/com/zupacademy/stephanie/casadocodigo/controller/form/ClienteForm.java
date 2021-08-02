package br.com.zupacademy.stephanie.casadocodigo.controller.form;

import br.com.zupacademy.stephanie.casadocodigo.model.Cliente;
import br.com.zupacademy.stephanie.casadocodigo.model.Estado;
import br.com.zupacademy.stephanie.casadocodigo.model.Pais;
import br.com.zupacademy.stephanie.casadocodigo.validacao.ObjectExists;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class ClienteForm {
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
    @ObjectExists(field = "id", entity = Pais.class)
    private Long pais;

    private Long estado;


    @Deprecated
    public ClienteForm() {
    }

    public ClienteForm(Long id, String email, String nome, String sobrenome, String documento, String endereco,
                       String complemento, String cidade, Long pais, String cep, String telefone, Long estado) {
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
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteForm that = (ClienteForm) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email)
                && Objects.equals(documento, that.documento) && Objects.equals(nome, that.nome)
                && Objects.equals(sobrenome, that.sobrenome) && Objects.equals(endereco, that.endereco)
                && Objects.equals(complemento, that.complemento) && Objects.equals(cidade, that.cidade)
                && Objects.equals(cep, that.cep) && Objects.equals(telefone, that.telefone) && Objects.equals(pais, that.pais)
                && Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public Long getPais() {
        return pais;
    }

    public Long getEstado() {
        return estado;
    }
}
