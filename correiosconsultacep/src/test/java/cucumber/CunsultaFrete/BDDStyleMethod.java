package cucumber.CunsultaFrete;
import io.restassured.http.ContentType;
import org.hamcrest.core.Is;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class BDDStyleMethod {

    public static void PerformPOSTWithBodyParameter(){
        HashMap<String,String> postContent = new HashMap<>();

        postContent.put("cep", "11450001");

        given()
                .contentType(ContentType.JSON)
                .with()
                .body(postContent).
                when()
                .post("http://localhost:5000/endereco/consulta").
                then()
                .statusCode(200);
    }
}
