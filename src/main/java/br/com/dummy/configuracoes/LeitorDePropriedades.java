package br.com.dummy.configuracoes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LeitorDePropriedades {

    public static String lerPropriedades(String chave){
        String ambiente = System.getenv("AMBIENTE");
        Properties propriedade = new Properties();

        if (ambiente == null) {
            ambiente = "dev";
        }

        String caminhoArquivo = ambiente + ".properties";

        try (InputStream input = LeitorDePropriedades.class.getClassLoader().getResourceAsStream(caminhoArquivo)) {
            if (input == null) {
                throw new FileNotFoundException("Arquivo de propriedades não encontrado: " + caminhoArquivo);
            }

            propriedade.load(input);
            return propriedade.getProperty(chave);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
