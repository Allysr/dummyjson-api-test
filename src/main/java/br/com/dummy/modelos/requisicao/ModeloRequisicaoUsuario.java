package br.com.dummy.modelos.requisicao;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ModeloRequisicaoUsuario {
    private String email;
    private String senha;
}
