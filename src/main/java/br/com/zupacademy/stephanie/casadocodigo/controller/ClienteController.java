package br.com.zupacademy.stephanie.casadocodigo.controller;


import br.com.zupacademy.stephanie.casadocodigo.controller.dto.ClienteDto;
import br.com.zupacademy.stephanie.casadocodigo.controller.dto.ClienteDtoResposta;
import br.com.zupacademy.stephanie.casadocodigo.model.Cliente;
import br.com.zupacademy.stephanie.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.stephanie.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.stephanie.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.stephanie.casadocodigo.validacao.PaisEstadoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

        @Autowired
        private ClienteRepository clienteRepository;
        @Autowired
        private PaisRepository paisRepository;
        @Autowired
        private EstadoRepository estadoRepository;
        @Autowired
        private PaisEstadoValidator paisEstadoValidator;

        @InitBinder
        public void init(WebDataBinder binder) {
            binder.addValidators(paisEstadoValidator);
        }

    public ClienteController(ClienteRepository clienteRepository, PaisRepository paisRepository, EstadoRepository estadoRepository, PaisEstadoValidator paisEstadoValidator) {
        this.clienteRepository = clienteRepository;
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
        this.paisEstadoValidator = paisEstadoValidator;
    }
    @PostMapping
    @Transactional
    public ResponseEntity<ClienteDtoResposta> cadastrar(@RequestBody @Valid ClienteDto cliente) {
        Cliente clienteObj = cliente.converter(paisRepository, estadoRepository);
        clienteRepository.save(clienteObj);

        return ResponseEntity.ok(new ClienteDtoResposta(clienteObj));
    }
}
