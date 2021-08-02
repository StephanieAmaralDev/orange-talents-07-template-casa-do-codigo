package br.com.zupacademy.stephanie.casadocodigo.validacao;

import br.com.zupacademy.stephanie.casadocodigo.controller.dto.ClienteDto;
import br.com.zupacademy.stephanie.casadocodigo.model.Estado;
import br.com.zupacademy.stephanie.casadocodigo.model.Pais;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

    @Component
    public class PaisEstadoValidator implements Validator {

    private EntityManager em;

    public PaisEstadoValidator(EntityManager em) {
        this.em = em;
    }


        @Override
        public boolean supports(Class<?> aClass) {
            return ClienteDto.class.isAssignableFrom(aClass);
        }

        @Override
        public void validate(Object o, Errors errors) {
            if (errors.hasErrors()) {
                return;
            }
            ClienteDto request = (ClienteDto) o;
            if(request.estadoIsPresent()) {
                Pais pais = em.find(Pais.class, request.getPais());
                Estado estado = em.find(Estado.class, request.getEstado());

                if(!estado.pertencePais(pais))
                    errors.rejectValue("estado", null,"Este estado não é do país selecionado");
            }
        }
    }

