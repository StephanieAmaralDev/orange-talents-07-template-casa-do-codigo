package br.com.zupacademy.stephanie.casadocodigo.controller.dto;

import br.com.zupacademy.stephanie.casadocodigo.model.Estado;
import br.com.zupacademy.stephanie.casadocodigo.model.Pais;
import br.com.zupacademy.stephanie.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.stephanie.casadocodigo.validacao.ObjectExists;
import br.com.zupacademy.stephanie.casadocodigo.validacao.UniqueColumn;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Optional;

public class EstadoDto {
    @NotBlank
    @UniqueColumn(field = "nome", entity = Estado.class)
    private String nome;

    @NotNull
    @ObjectExists(field = "id", entity = Pais.class)
    private long pais;

    public Estado converter(PaisRepository paisRepository) {
        Optional<Pais> paisObj = paisRepository.findById(pais);

        return new Estado(nome, paisObj.get());
    }

    public String getNome() {
        return nome;
    }

    public long getPais() {
        return pais;
    }

    public EstadoDto(String nome, long pais) {
        this.nome = nome;
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoDto estadoDto = (EstadoDto) o;
        return pais == estadoDto.pais && Objects.equals(nome, estadoDto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, pais);
    }

    @Override
    public String toString() {
        return "EstadoDto{" +
                "nome='" + nome + '\'' +
                ", pais=" + pais +
                '}';
    }
}


