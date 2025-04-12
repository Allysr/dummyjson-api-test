package br.com.dummy.modelos.resposta;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ModeloRespostaUsuario {
    private String email;
    private String senha;
}
