package cucumber.CunsultaFrete;

import br.com.correiosconsultacep.model.dtos.Request;
import br.com.correiosconsultacep.service.interfaceservice.ServicoCalculoFrete;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ConsultaFreteEtapas {
    private ServicoCalculoFrete freteService;
    private String resposta;

    @Given("Eu performo uma operação com o cep {string}")
    public void euPerformoUmaOperaçãoEmComOCep(String cep) {

        Request enderecoRequest = new Request();
        enderecoRequest.setCep(cep);
        resposta = freteService.executa(enderecoRequest);
    }

    @When("Eu pesquiso o cep {string}")
    public void euPesquisoOCep(String cep) {
        Request enderecoRequest = new Request();
        enderecoRequest.setCep(cep);
        resposta = freteService.executa(enderecoRequest);
    }

    @Then("Eu encontro o frete")
    public void euEncontroOFrete() {
        Assert.assertTrue(resposta.contains("frete"));
    }

    @Then("Eu recebo mensagem de erro CEP não encontrado")
    public void euReceboMensagemDeErroCEPInexistente() {
        String mensagem = "CEP inexistente, por favor repetir a consulta com dados válidos.";
        Assert.assertEquals(resposta, mensagem);
    }

    @Then("Eu recebo mensagem de erro CEP inválido")
    public void euReceboMensagemDeErroCEPInválido() {
        String mensagem = "CEP inválido, por favor repetir a consulta com caracteres númericos da seguinte forma xxxxx-xxx ou xxxxxxxx";
        Assert.assertEquals(resposta, mensagem);
    }
}
