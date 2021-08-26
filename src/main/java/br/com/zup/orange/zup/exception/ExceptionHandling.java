package br.com.zup.orange.zup.exception;


import br.com.zup.orange.zup.exception.dto.ErrrorFormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestControllerAdvice
public class ExceptionHandling  {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, IllegalArgumentException.class})
    public List<ErrrorFormDto> handle(MethodArgumentNotValidException exception){

        List<ErrrorFormDto> dto = new ArrayList<>();
        //Pega o campo do erro
        List<FieldError> fieldError = exception.getBindingResult().getFieldErrors();
        fieldError.forEach(e -> {
            //Pega a mensagem e seu idioma
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrrorFormDto error = new ErrrorFormDto(e.getField(), message); //Passa o campo e erro o dto
            dto.add(error); // adiciona o erro a lista
        });

        return dto;
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleGlobalExceptions(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("Error", "Internal error "+e.getMessage()));
    }

}