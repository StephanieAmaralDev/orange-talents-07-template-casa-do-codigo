package br.com.zupacademy.stephanie.casadocodigo.validacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroValidacaoHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroFormularioDto> handle(MethodArgumentNotValidException methodArgumentNotValidException){
        List<ErroFormularioDto> dto = new ArrayList<>();

        List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e ->{
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroFormularioDto erro = new ErroFormularioDto(e.getField(), mensagem);
            dto.add(erro);
        });
        return dto;
    }
}