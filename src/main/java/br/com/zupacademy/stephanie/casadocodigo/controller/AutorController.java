package br.com.zupacademy.stephanie.casadocodigo.controller;

import br.com.zupacademy.stephanie.casadocodigo.controller.dto.AutorDto;
import br.com.zupacademy.stephanie.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.stephanie.casadocodigo.model.Autor;
import br.com.zupacademy.stephanie.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/autor")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private ValidaEmailDuplicado validaEmailDuplicado;

    @InitBinder //realiza configurações iniciais
    public void init(WebDataBinder binder) {

        binder.addValidators(validaEmailDuplicado);
    }

    @PostMapping
    public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm autorForm, UriComponentsBuilder uriComponentsBuilder) {
        Autor autor = autorForm.converter(autorRepository);
        autorRepository.save(autor);
        URI uri = uriComponentsBuilder.path("/autor").buildAndExpand(autor.getNome()).toUri();
        return ResponseEntity.ok().build();
    }
}
