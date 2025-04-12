import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Teste {
    private static final String BASE_URL = "https://dummyjson.com";

    @Test
    public void primeiroTeste(){
        given().baseUri("BASE_URL")
                .when().get()
                .then().statusCode(200);

    }
}
