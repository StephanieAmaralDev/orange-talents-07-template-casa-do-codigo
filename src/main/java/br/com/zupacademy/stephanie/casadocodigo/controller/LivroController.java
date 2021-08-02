package br.com.zupacademy.stephanie.casadocodigo.controller;

import br.com.zupacademy.stephanie.casadocodigo.controller.dto.DetalheLivroDto;
import br.com.zupacademy.stephanie.casadocodigo.controller.dto.ItemListaLivroDto;
import br.com.zupacademy.stephanie.casadocodigo.controller.dto.LivroDto;
import br.com.zupacademy.stephanie.casadocodigo.controller.form.LivroForm;
import br.com.zupacademy.stephanie.casadocodigo.model.Livro;
import br.com.zupacademy.stephanie.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.stephanie.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.stephanie.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/livros")
    public List<ItemListaLivroDto> lista() {
        List<Livro> livros = livroRepository.findAll();
        return livros.stream().map(ItemListaLivroDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalheLivroDto> detalha(@PathVariable Long id) {
        Livro livro = livroRepository.findById(id).orElse(null);

        if (livro == null) {
            return ResponseEntity.notFound().build();
        }

        DetalheLivroDto response = new DetalheLivroDto(livro);
        return ResponseEntity.ok().body(response);
    }
}