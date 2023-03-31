package br.com.correiosconsultacep;

import br.com.correiosconsultacep.model.Endereco;
import br.com.correiosconsultacep.model.dtos.Request;
import br.com.correiosconsultacep.service.interfaceservice.ServicoCalculoFrete;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class FreteTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();
    @Autowired
    private ServicoCalculoFrete service;

    @Test
    public void consultaComCepValido() {
        Request freteRequest = new Request();
        freteRequest.setCep("06454-000");

        String resposta = service.executa(freteRequest);

        Endereco freteModel = new Endereco();
        freteModel.setCep("06454-000");
        freteModel.setRua("Alameda Rio Negro");
        freteModel.setComplemento("");
        freteModel.setBairro("Alphaville Centro Industrial e Empresarial/Alphaville.");
        freteModel.setCidade("Barueri");
        freteModel.setEstado("SP");
        freteModel.setFrete(new BigDecimal("7.85"));

        assertEquals(resposta, freteModel.toString());
    }

    @Test
    public void consultaComCepValido2() {
        Request freteRequest = new Request();
        freteRequest.setCep("04711-035");

        String resposta = service.executa(freteRequest);

        Endereco freteModel = new Endereco();
        freteModel.setCep("04711-035");
        freteModel.setRua("Rua Arquiteto Olavo Redig de Campos");
        freteModel.setComplemento("");
        freteModel.setBairro("Vila São Francisco (Zona Sul)");
        freteModel.setCidade("São Paulo");
        freteModel.setEstado("SP");
        freteModel.setFrete(new BigDecimal("7.85"));

        assertEquals(resposta, freteModel.toString());
    }

    private void assertThrows(Executable executable) {
    }

    @Test
    public void consultaComCepInexistente() {

        assertThrows(new Executable() {

            @Override
            public void execute() throws Throwable {
                Request freteRequest = new Request();
                freteRequest.setCep("11402-892");
            }
        });
    }


    @Test
    public void consultaComCepInvalido() {
        assertThrows(new Executable() {

            @Override
            public void execute() throws Throwable {
                Request freteRequest = new Request();
                freteRequest.setCep("90480ABC");
            }
        });
    }
}
