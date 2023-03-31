package br.com.correiosconsultacep.service.serviceimpl;

import br.com.correiosconsultacep.model.Endereco;
import br.com.correiosconsultacep.model.dtos.Request;
import br.com.correiosconsultacep.model.dtos.Response;
import br.com.correiosconsultacep.model.enuns.ValoresDeFretePorEstadoEnum;
import br.com.correiosconsultacep.service.exceptions.ErrorCepException;
import br.com.correiosconsultacep.service.exceptions.ObjectNotFoundException;
import br.com.correiosconsultacep.service.interfaceservice.ServicoCalculoFrete;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Implementação da interface ServicoCalculoFrete que realiza o cálculo do frete para um determinado CEP.
 */
@RequiredArgsConstructor
@Service
public class ServicoCalculoFreteImpl implements ServicoCalculoFrete {

    /**
     * Realiza a consulta do CEP na API ViaCEP e retorna os dados do endereço correspondente.
     *
     * @param request objeto contendo o CEP a ser consultado.
     * @return string contendo os dados do endereço correspondente ao CEP.
     * @throws ObjectNotFoundException caso a API ViaCEP retorne um erro de CEP inexistente.
     * @throws ErrorCepException caso o CEP informado não esteja no formato esperado (xxxxx-xxx ou xxxxxxxx).
     */
    @Override
    public String executa(Request request) {
        try{
            // Realiza a requisição GET para a API ViaCEP
            Response response  = new RestTemplate().getForEntity("https://viacep.com.br/ws/" + request.getCep() + "/json/", Response.class).getBody();

            // Verifica se a resposta contém um erro
            if(response != null && response.isErro()){
                throw new ObjectNotFoundException("CEP inexistente, por favor repetir a consulta com dados válidos.");
            }

            // Cria um objeto Endereco a partir da resposta da API
            Endereco endereco = new Endereco(response);

            // Retorna a string contendo os dados do endereço
            return endereco.toString();

            // Caso a requisição retorne um erro devido ao formato inválido do CEP, lança uma exceção do tipo ErrorCepException
        }catch( HttpClientErrorException.BadRequest exception){
            throw new ErrorCepException("CEP inválido, por favor repetir a consulta com caracteres numericos da seguinte forma /n Ex: xxxxx-xxx ou xxxxxxxx");
        }
    }

    /**
     * Retorna o valor do frete para um determinado estado.
     *
     * @param uf estado para o qual se deseja obter o valor do frete.
     * @return string contendo o valor do frete para o estado informado.
     */
    @Override
    public String valorFrete(String uf) {
        // Utiliza o enum ValoresDeFretePorEstadoEnum para obter o valor do frete para o estado informado
        return ValoresDeFretePorEstadoEnum.find(uf);
    }
}

