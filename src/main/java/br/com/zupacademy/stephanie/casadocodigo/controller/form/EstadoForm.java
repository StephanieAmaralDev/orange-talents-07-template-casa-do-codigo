package br.com.zupacademy.stephanie.casadocodigo.controller.form;

import java.util.Objects;

public class EstadoForm {

    private String nome;
    private long pais;

    public String getNome() {
        return nome;
    }

    public long getPais() {
        return pais;
    }

    public EstadoForm(String nome, long pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public EstadoForm() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoForm that = (EstadoForm) o;
        return pais == that.pais && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, pais);
    }

    @Override
    public String toString() {
        return "EstadoForm{" +
                "nome='" + nome + '\'' +
                ", pais=" + pais +
                '}';
    }
}
