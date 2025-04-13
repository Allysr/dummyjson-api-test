package br.com.dummy.util;

import static br.com.dummy.fabrica.FabricaLogin.dadosLoginValido;
import static io.restassured.RestAssured.given;

public class ObterToken {
    public static final String CAMINHO_LOGIN = "/auth/login";

    public static String obterTokenLogin(){
        String token =
                given().
                        body(dadosLoginValido()).
                        when().
                        post(CAMINHO_LOGIN).
                        then().
                        extract().path("accessToken");
        return token;
    }

}
