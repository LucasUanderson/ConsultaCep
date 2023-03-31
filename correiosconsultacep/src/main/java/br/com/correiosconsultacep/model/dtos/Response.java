package br.com.correiosconsultacep.model.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A classe Response representa o objeto que é retornado pela consulta de um determinado CEP
 */
@NoArgsConstructor
@Getter
@Setter
public class Response {
    /**
     * Esta classe possui um construtor que recebe todos os atributos como parâmetros e também possui os métodos getters e setters para cada atributo.
     */
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private boolean erro;

    public Response(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, boolean erro) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.erro = erro;
    }
}
