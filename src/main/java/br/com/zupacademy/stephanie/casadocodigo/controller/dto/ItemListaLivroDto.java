package br.com.zupacademy.stephanie.casadocodigo.controller.dto;

import br.com.zupacademy.stephanie.casadocodigo.model.Livro;

public class ItemListaLivroDto {

    private Long id;
    private String titulo;


    public ItemListaLivroDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}