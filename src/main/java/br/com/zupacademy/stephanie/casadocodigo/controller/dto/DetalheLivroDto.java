package br.com.zupacademy.stephanie.casadocodigo.controller.dto;

import br.com.zupacademy.stephanie.casadocodigo.model.Livro;


public class DetalheLivroDto {

        private Long id;
        private String titulo;
        private String resumo;
        private String sumario;
        private String isbn;
        private Integer numeroDePaginas;
        private AutorDto autor;

        public DetalheLivroDto(Livro livro) {
            this.id = livro.getId();
            this.titulo = livro.getTitulo();
            this.resumo = livro.getResumo();
            this.sumario = livro.getSumario();
            this.isbn = livro.getIsbn();
            this.numeroDePaginas = livro.getNumeroPaginas();
            this.autor = new AutorDto(livro.getAutor());
        }

    public DetalheLivroDto() {

    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public AutorDto getAutor() {
        return autor;
    }


}





