package cucumber.CunsultaFrete;
import br.com.correiosconsultacep.config.restassured.RestAssuredExtension;
import com.samucatezu.consultafreteapi.utils.RestAssuredExtension;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import java.util.HashMap;
import java.util.Map;
public class POSTProfileSteps {

    private static ResponseOptions<Response> response;

    @Given("I ensure to Perform POST operation for {string} with body as")
    public void iEnsureToPerformPOSTOperationForWithBodyAs(String url) {

        Map<String, String> body = new HashMap<>();

        body.put("cep", "1145001");
        // Perform post operation
        RestAssuredExtension.PostOpsWithBody(url, body);
    }
}
