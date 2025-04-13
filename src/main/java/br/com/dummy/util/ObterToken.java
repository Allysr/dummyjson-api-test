package br.com.dummy.util;

import br.com.dummy.modelos.requisicao.ModeloRequisicaoUsuario;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ObterToken {
    public static final String CAMINHO_LOGIN = "/auth/login";

    public static String obterTokenLogin(RequestSpecification configuracaoRequesicao,
                                         ModeloRequisicaoUsuario usuario){
        String token =
                given().
                        spec(configuracaoRequesicao).
                        body(usuario).
                        when().
                        post(CAMINHO_LOGIN).
                        then().
                        extract().path("accessToken");
        return token;
    }

}
