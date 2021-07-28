package br.com.zupacademy.stephanie.casadocodigo.controller.dto;

import java.util.Objects;

public class CategoriaDto {

    private String nome;

    public CategoriaDto(String nome) {
        this.nome = nome;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaDto that = (CategoriaDto) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
