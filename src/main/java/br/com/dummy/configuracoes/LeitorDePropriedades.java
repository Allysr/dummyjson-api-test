package br.com.dummy.configuracoes;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LeitorDePropriedades {

    public static String lerPropriedades(String chave){
        String ambiente = System.getenv("AMBIENTE");
        Properties propriedade = new Properties();

        if (ambiente == null) {
            ambiente = "dev";
        }

        String caminhoArquivo = ambiente + ".properties";

        try{
            FileInputStream arquivo = new FileInputStream(caminhoArquivo);
            propriedade.load(arquivo);

            return propriedade.getProperty(chave);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
