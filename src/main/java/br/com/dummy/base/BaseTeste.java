package br.com.dummy.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;

import static br.com.dummy.configuracoes.LeitorDePropriedades.lerPropriedades;

public class BaseTeste {

    @BeforeEach
    public void baseDoTeste(){
        RequestSpecification requesicao = new RequestSpecBuilder()
                .setBaseUri(lerPropriedades("base.url"))
                .setContentType("application/json")
                .build();

        ResponseSpecification resposta = new ResponseSpecBuilder()
                .expectContentType("application/json")
                .build();

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }


}
