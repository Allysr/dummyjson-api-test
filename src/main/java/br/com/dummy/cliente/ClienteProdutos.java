package br.com.dummy.cliente;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class ClienteProdutos {
    private static final String CAMINHO_PRODUTOS = "/products";
    private static final String CAMINHO_PRODUTOS_AUTENTICACAO = "auth/products";

    public static ValidatableResponse consultaProdutos (RequestSpecification configuracaoRequisicao,
                                                        ResponseSpecification configuracaoResposta){
        return given().
                spec(configuracaoRequisicao).
               when().
                get(CAMINHO_PRODUTOS).
               then().
                spec(configuracaoResposta);
    }

    public static ValidatableResponse consultaProdutosComAutenticacao (RequestSpecification configuracaoRequisicao,
                                                                       ResponseSpecification configuracaoResposta,
                                                                       String token){
        return given().
                 spec(configuracaoRequisicao).
                 header("Authorization", "Bearer " + token).
                when().
                 get(CAMINHO_PRODUTOS_AUTENTICACAO).
                then().
                 spec(configuracaoResposta);
    }


}
