package br.com.dummy.cliente;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static br.com.dummy.fabrica.FabricaLogin.dadosLoginValido;
import static io.restassured.RestAssured.given;

public class ClienteLogin {

    public static final String CAMINHO_LOGIN = "/auth/login";

    public static Response autenticarUsuario (RequestSpecification configuracaoRequisicao){
        return given().
                spec(configuracaoRequisicao).
                body(dadosLoginValido()).
                when().
                post(CAMINHO_LOGIN);
    }
}
