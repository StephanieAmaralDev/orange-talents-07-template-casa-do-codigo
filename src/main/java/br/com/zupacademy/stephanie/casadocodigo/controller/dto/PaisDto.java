package br.com.zupacademy.stephanie.casadocodigo.controller.dto;

import br.com.zupacademy.stephanie.casadocodigo.model.Pais;
import br.com.zupacademy.stephanie.casadocodigo.validacao.UniqueColumn;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class PaisDto {

    @NotBlank
    @UniqueColumn(field = "nome", entity = Pais.class)
    private String nome;

    public Pais converter() {
        return new Pais(nome);
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaisDto paisDto = (PaisDto) o;
        return Objects.equals(nome, paisDto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "PaisDto{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
