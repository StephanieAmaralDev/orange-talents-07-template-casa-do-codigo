package br.com.zupacademy.stephanie.casadocodigo.controller.form;

import br.com.zupacademy.stephanie.casadocodigo.model.Autor;
import br.com.zupacademy.stephanie.casadocodigo.model.Categoria;
import br.com.zupacademy.stephanie.casadocodigo.model.Livro;
import br.com.zupacademy.stephanie.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.stephanie.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.stephanie.casadocodigo.repository.LivroRepository;
import br.com.zupacademy.stephanie.casadocodigo.validacao.ObjectExists;
import br.com.zupacademy.stephanie.casadocodigo.validacao.UniqueColumn;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Optional;

public class LivroForm {

    @UniqueColumn(field = "titulo", entity = Livro.class)
    @NotBlank
    private String titulo;

    @NotBlank @Length(max = 500)
    private String resumo;

    @NotBlank
    @Lob
    @Column(columnDefinition = "TEXT")
    private String sumario;

    @NotNull
    @Min(20)
    private Double preco;

    @NotNull @Min(100)
    private Integer numeroPaginas;

    @NotBlank
    @UniqueColumn(field = "isbn", entity = Livro.class)
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;


    @NotNull
    @ObjectExists(field = "id", entity = Categoria.class)
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Long categoria;

    @ObjectExists(field = "id", entity = Autor.class)
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Long autor;

    public LivroForm() {
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

    public Double getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }


    public LivroForm(String titulo, String resumo, String sumario, Double preco, Integer numeroPaginas, String isbn, LocalDate dataPublicacao, Categoria categoria, Autor autor) {

        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;

    }

    public Livro converter(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        Optional<Autor> autorObj = autorRepository.findById(autor);
        Optional<Categoria> categoriaObj = categoriaRepository.findById(categoria);
        return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, categoriaObj.get(), autorObj.get());
    }
}
