package br.com.correiosconsultacep.model;

import br.com.correiosconsultacep.model.dtos.Response;
import br.com.correiosconsultacep.model.enuns.ValoresDeFretePorEstadoEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 Classe Endereco representa um endereço com informações como CEP, rua, complemento, bairro, cidade, estado e frete.
 Possui dois construtores, um vazio e outro que recebe um objeto do tipo Response contendo informações de endereço.
 Possui também um método toString() que retorna uma string formatada com todas as informações do endereço.
 */
@Getter
@Setter
@NoArgsConstructor
public class Endereco {

    private String cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private BigDecimal frete;

    public Endereco(Response response ) {
        this.cep = response.getCep();
        this.rua = response.getLogradouro();
        this.complemento = response.getComplemento();
        this.bairro = response.getBairro();
        this.cidade = response.getLocalidade();
        this.estado = response.getUf();
        this.frete = new BigDecimal(ValoresDeFretePorEstadoEnum.find(response.getUf()));
    }

    @Override
    public String toString() {
        return "{\n" +
                "   \"cep\": \"" + cep + "\",\n" +
                "   \"rua\": \"" + rua + "\"\n" +
                "   \"complemento\": \"" + complemento + "\",\n" +
                "   \"bairro\": \"" + bairro + "\",\n" +
                "   \"cidade\": \"" + cidade + "\",\n" +
                "   \"estado\": \"" + estado + "\",\n" +
                "   \"frete\": " + frete.toString() + "\n" +
                "}";
    }
}

