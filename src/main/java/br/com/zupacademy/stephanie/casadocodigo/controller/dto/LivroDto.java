package br.com.zupacademy.stephanie.casadocodigo.controller.dto;

import br.com.zupacademy.stephanie.casadocodigo.model.Autor;
import br.com.zupacademy.stephanie.casadocodigo.model.Categoria;
import java.time.LocalDate;
import java.util.Objects;

public class LivroDto {
    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private Double preco;
    private Integer numeroPaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private Categoria categoria;
    private Autor autor;

    public LivroDto(String titulo, String resumo, String sumario, Double preco, Integer numeroPaginas, String isbn, LocalDate dataPublicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LivroDto livroDto = (LivroDto) o;
        return Objects.equals(id, livroDto.id) && Objects.equals(titulo, livroDto.titulo) && Objects.equals(resumo, livroDto.resumo) && Objects.equals(sumario, livroDto.sumario) && Objects.equals(preco, livroDto.preco) && Objects.equals(numeroPaginas, livroDto.numeroPaginas) && Objects.equals(isbn, livroDto.isbn) && Objects.equals(dataPublicacao, livroDto.dataPublicacao) && Objects.equals(categoria, livroDto.categoria) && Objects.equals(autor, livroDto.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, categoria, autor);
    }
}
