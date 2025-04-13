package br.com.dummy.cliente;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ClienteProdutos {
    private static final String CAMINHO_PRODUTOS = "/products";

    public static Response consultaProdutos (RequestSpecification configuracaoRequisicao){
        return given().
                spec(configuracaoRequisicao).
               when().
                get(CAMINHO_PRODUTOS);
    }

}
