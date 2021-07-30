package br.com.zupacademy.stephanie.casadocodigo.controller;

import br.com.zupacademy.stephanie.casadocodigo.controller.dto.CategoriaDto;
import br.com.zupacademy.stephanie.casadocodigo.controller.dto.LivroDto;
import br.com.zupacademy.stephanie.casadocodigo.controller.form.CategoriaForm;
import br.com.zupacademy.stephanie.casadocodigo.controller.form.LivroForm;
import br.com.zupacademy.stephanie.casadocodigo.model.Categoria;
import br.com.zupacademy.stephanie.casadocodigo.model.Livro;
import br.com.zupacademy.stephanie.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.stephanie.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.stephanie.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping(value = "/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;
    private AutorRepository autorRepository;
    private CategoriaRepository categoriaRepository;

    public LivroController(LivroRepository livroRepository, AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid LivroForm livroForm) {
        Livro livro = livroForm.converter(autorRepository, categoriaRepository);
        livroRepository.save(livro);
        return ResponseEntity.ok().build();
    }
}
