package br.com.dummy.cliente;

import br.com.dummy.modelos.requisicao.ModeloRequisicaoUsuario;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class ClienteLogin {

    public static final String CAMINHO_LOGIN = "/auth/login";

    public static ValidatableResponse autenticarUsuario (RequestSpecification configuracaoRequisicao,
                                                         ResponseSpecification configuracaoResposta,
                                                         ModeloRequisicaoUsuario usuario){
        return given().
                    spec(configuracaoRequisicao).
                    body(usuario).
                when().
                    post(CAMINHO_LOGIN).
                then().
                    spec(configuracaoResposta);
    }
}
