package br.com.dummy.modelos.requisicao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ModeloRequisicaoUsuario {
    private String username;
    private String password;
}
