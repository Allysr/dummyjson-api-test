package br.com.dummy.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;

import static br.com.dummy.configuracoes.LeitorDePropriedades.lerPropriedades;

public class BaseTeste {
    protected static RequestSpecification configuracaoRequisicao;
    protected static ResponseSpecification configuracaoResposta;

    @BeforeEach
    public void baseDoTeste(){
        configuracaoRequisicao = new RequestSpecBuilder()
                .setBaseUri(lerPropriedades("base.url"))
                .setContentType("application/json")
                .build();

        configuracaoResposta = new ResponseSpecBuilder()
                .expectContentType("application/json")
                .log(LogDetail.ALL)
                .build();

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
