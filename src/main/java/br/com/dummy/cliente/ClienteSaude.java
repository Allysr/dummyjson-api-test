package br.com.dummy.cliente;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ClienteSaude {
    private static final String CAMINHO_TESTE = "/test";

    public static Response consultaSaudeDaApi (RequestSpecification configuracaoRequisicao){
        return given().
                spec(configuracaoRequisicao).
               when().
                get(CAMINHO_TESTE);
    }
}
