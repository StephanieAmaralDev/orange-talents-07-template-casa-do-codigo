package br.com.zupacademy.stephanie.casadocodigo.controller;

import br.com.zupacademy.stephanie.casadocodigo.controller.dto.PaisDto;
import br.com.zupacademy.stephanie.casadocodigo.repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/pais")
public class PaisController {

    private PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid PaisDto pais) {
        paisRepository.save(pais.converter());

        return ResponseEntity.ok().build();
    }
}
