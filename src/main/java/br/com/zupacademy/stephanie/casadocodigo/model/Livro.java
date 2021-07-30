package br.com.zupacademy.stephanie.casadocodigo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank @Length(max = 500)
    private String resumo;

    @NotBlank
    @Lob
    @Column(columnDefinition = "TEXT")
    private String sumario;

    @NotNull @Min(20)
    private Double preco;

    @NotNull @Min(100)
    private Integer numeroPaginas;

    @NotBlank
    @ISBN
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @ManyToOne
    @NotNull
    private Categoria categoria;

    @ManyToOne
    @NotNull
    private Autor autor;


    public Livro() {
    }

    public Livro(String titulo, String resumo, String sumario, Double preco, Integer numeroPaginas, String isbn, LocalDate dataPublicacao, Categoria categoria, Autor autor) {
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

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id) && Objects.equals(titulo, livro.titulo) && Objects.equals(resumo, livro.resumo) && Objects.equals(sumario, livro.sumario) && Objects.equals(preco, livro.preco) && Objects.equals(numeroPaginas, livro.numeroPaginas) && Objects.equals(isbn, livro.isbn) && Objects.equals(dataPublicacao, livro.dataPublicacao) && Objects.equals(categoria, livro.categoria) && Objects.equals(autor, livro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, categoria, autor);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", categoria=" + categoria +
                ", autor=" + autor +
                '}';
    }
}
