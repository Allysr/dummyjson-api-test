package br.com.dummy.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Allure;

public class EvidenciasUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void anexarJsonAoReporte(Object objeto) {
        try {
            String jsonFormatado = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objeto);
            Allure.addAttachment("Corpo da Resposta", "application/json", jsonFormatado);
        } catch (JsonProcessingException e) {
            Allure.addAttachment("Corpo da Resposta" + " (erro ao formatar)", objeto.toString());
        }
    }
}