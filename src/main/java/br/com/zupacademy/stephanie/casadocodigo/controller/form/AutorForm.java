package br.com.zupacademy.stephanie.casadocodigo.controller.form;

import br.com.zupacademy.stephanie.casadocodigo.model.Autor;
import br.com.zupacademy.stephanie.casadocodigo.model.Categoria;
import br.com.zupacademy.stephanie.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.stephanie.casadocodigo.validacao.UniqueColumn;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AutorForm {

    @NotNull @NotEmpty
    private String nome;

    @Email
    @NotNull @NotEmpty
    @UniqueColumn(field = "email", entity = Autor.class)
    private String email;

    @NotNull @NotEmpty @Length(max = 400)
    private String descricao;


    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }


    public Autor converter(AutorRepository autorRepository) {
        Autor curso = autorRepository.findByNome(nome);
        return new Autor(nome, email, descricao);
    }
}
