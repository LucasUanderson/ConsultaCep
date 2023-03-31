package br.com.correiosconsultacep.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe utilizada para armazenar dados de requisição para consulta de endereço por CEP.
 */
@Setter
@Getter
@AllArgsConstructor
public class Request {

    /**
     * CEP a ser consultado.
     */
    private String cep;

    public Request() {
        // Construtor vazio
    }


}

