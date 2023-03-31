package br.com.correiosconsultacep.service.interfaceservice;

import br.com.correiosconsultacep.model.dtos.Request;

/**
 * Interface ServicoCalculoFrete define os métodos para cálculo de frete.
 * A interface define dois métodos: executa e valorFrete. O primeiro método recebe um objeto Request e retorna uma String
 * com o resultado do cálculo do frete. O segundo método recebe uma String com a sigla do estado (UF) e retorna uma String
 * com o valor do frete para aquele estado.
 */
public interface ServicoCalculoFrete {


    public String executa(Request request);

    public String valorFrete(String uf);

}
