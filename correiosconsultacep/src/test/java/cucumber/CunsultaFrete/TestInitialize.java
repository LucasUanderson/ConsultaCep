package cucumber.CunsultaFrete;

import br.com.correiosconsultacep.config.restassured.RestAssuredExtension;
import org.junit.Before;

public class TestInitialize {
    @Before
    public void TestSetup(){
        RestAssuredExtension restAssuredExtension = new RestAssuredExtension();
    }
}
