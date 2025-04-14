package br.com.dummy.fabrica;

import br.com.dummy.modelos.requisicao.ModeloRequisicaoUsuario;

import java.util.stream.Stream;

import static br.com.dummy.util.LeitorDePropriedades.lerPropriedades;

public class FabricaLogin {
    public static ModeloRequisicaoUsuario dadosLoginValido(){
        return ModeloRequisicaoUsuario.builder().
                username(lerPropriedades("usuario")).
                password(lerPropriedades("senha")).
                build();
    }

    public static ModeloRequisicaoUsuario dadosLoginInvalido() {
        return ModeloRequisicaoUsuario.builder().
                username(lerPropriedades("usuario")).
                password("SenhaIncorreta123").
                build();
    }

    public static Stream<ModeloRequisicaoUsuario> dadosLoginsInvalidos() {
        return Stream.of(
                ModeloRequisicaoUsuario.builder()
                        .username("usuario1")
                        .password("senha1")
                        .build(),
                ModeloRequisicaoUsuario.builder()
                        .username("usuario2")
                        .password("senha2")
                        .build(),
                ModeloRequisicaoUsuario.builder()
                        .username("usuario3")
                        .password("senha3")
                        .build()

        );
    }

}
