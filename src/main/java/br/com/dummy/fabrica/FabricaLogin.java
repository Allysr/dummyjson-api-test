package br.com.dummy.fabrica;

import br.com.dummy.modelos.requisicao.ModeloRequisicaoUsuario;

import static br.com.dummy.util.LeitorDePropriedades.lerPropriedades;

public class FabricaLogin {
    public static ModeloRequisicaoUsuario dadosLoginValido(){
        return ModeloRequisicaoUsuario.builder().
                usuario(lerPropriedades("usuario")).
                senha(lerPropriedades("senha")).
                build();

    }
}
