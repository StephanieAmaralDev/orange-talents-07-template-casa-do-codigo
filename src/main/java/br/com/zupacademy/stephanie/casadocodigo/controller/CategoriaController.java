package br.com.zupacademy.stephanie.casadocodigo.controller;


import br.com.zupacademy.stephanie.casadocodigo.controller.dto.AutorDto;
import br.com.zupacademy.stephanie.casadocodigo.controller.dto.CategoriaDto;
import br.com.zupacademy.stephanie.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.stephanie.casadocodigo.controller.form.CategoriaForm;
import br.com.zupacademy.stephanie.casadocodigo.model.Autor;
import br.com.zupacademy.stephanie.casadocodigo.model.Categoria;
import br.com.zupacademy.stephanie.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.net.URI;

@RestController
@Validated
@RequestMapping(value = "/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid CategoriaForm categoriaForm) {
        Categoria categoria = categoriaForm.converter();
        categoriaRepository.save(categoria);

        return ResponseEntity.ok().build();
    }
}
