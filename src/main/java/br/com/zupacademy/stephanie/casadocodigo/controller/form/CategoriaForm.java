package br.com.zupacademy.stephanie.casadocodigo.controller.form;

import br.com.zupacademy.stephanie.casadocodigo.model.Autor;
import br.com.zupacademy.stephanie.casadocodigo.model.Categoria;
import br.com.zupacademy.stephanie.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.stephanie.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.stephanie.casadocodigo.validacao.UniqueColumn;

import javax.validation.constraints.NotBlank;


public class CategoriaForm {

    @NotBlank
    @UniqueColumn(field = "nome", entity = Categoria.class)
    private String nome;

   public CategoriaForm() {
    }

    public String getNome() {
        return nome;
    }

    public Categoria converter() {
        return new Categoria(this.nome);
    }
}
