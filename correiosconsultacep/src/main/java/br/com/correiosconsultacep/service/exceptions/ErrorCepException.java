package br.com.correiosconsultacep.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 Classe ErrorCepException representa uma exceção lançada quando um CEP é inválido.
 A exceção possui um construtor que recebe uma mensagem de erro e a repassa para a classe pai (RuntimeException).
 Além disso, a classe é anotada com a anotação @ResponseStatus com o valor HttpStatus.BAD_REQUEST, indicando que uma
 requisição mal-formada foi feita ao servidor.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ErrorCepException extends RuntimeException{


    public ErrorCepException(String message) {
        super(message);
    }

}
