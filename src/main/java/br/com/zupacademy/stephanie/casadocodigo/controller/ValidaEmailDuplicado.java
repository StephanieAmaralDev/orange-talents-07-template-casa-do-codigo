package br.com.zupacademy.stephanie.casadocodigo.controller;

import br.com.zupacademy.stephanie.casadocodigo.controller.form.AutorForm;
import br.com.zupacademy.stephanie.casadocodigo.model.Autor;
import br.com.zupacademy.stephanie.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

//Validator do Spring
@Component
public class ValidaEmailDuplicado  implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    //Verifica se a classe é suportada
    @Override
    public boolean supports(Class<?> aClass) {
        return AutorForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        //verifica se não há erros anteriores
        if(errors.hasErrors()){
            return;
        }

        AutorForm request = (AutorForm) o;
        Optional<Autor> autor = autorRepository.findByEmail(request.getEmail());
        if(autor.isPresent()) {
            errors.rejectValue("email",null, "Email já cadastrado." + request.getEmail());
        }
    }
}
