package br.com.zupacademy.stephanie.casadocodigo.controller;

import br.com.zupacademy.stephanie.casadocodigo.controller.dto.AutorDto;
import br.com.zupacademy.stephanie.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.stephanie.casadocodigo.model.Autor;
import br.com.zupacademy.stephanie.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm topicoForm, UriComponentsBuilder uriComponentsBuilder) {
        Autor autor = topicoForm.converter(autorRepository);
        autorRepository.save(autor);
        URI uri = uriComponentsBuilder.path("/autor").buildAndExpand(autor.getNome()).toUri();
        return ResponseEntity.ok().build();
    }
}
