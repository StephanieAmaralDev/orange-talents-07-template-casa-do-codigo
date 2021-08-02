package br.com.zupacademy.stephanie.casadocodigo.controller.form;

import java.util.Objects;

public class PaisForm {
    private String nome;

    public String getNome() {
        return nome;
    }

    public PaisForm(String nome) {
        this.nome = nome;
    }
    public PaisForm() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaisForm paisForm = (PaisForm) o;
        return Objects.equals(nome, paisForm.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "PaisForm{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
