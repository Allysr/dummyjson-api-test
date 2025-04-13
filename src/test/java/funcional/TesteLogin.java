package funcional;

import br.com.dummy.base.BaseTeste;
import br.com.dummy.modelos.resposta.ModeloRespostaUsuario;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static br.com.dummy.cliente.ClienteLogin.autenticarUsuario;
import static org.junit.jupiter.api.Assertions.*;

public class TesteLogin extends BaseTeste {

    @Test
    public void deveRealizarLoginObterToken(){
        ModeloRespostaUsuario usuario = autenticarUsuario(configuracaoRequisicao).
                then().
                spec(configuracaoResposta).
                statusCode(HttpStatus.SC_OK).
                extract().
                jsonPath().
                getObject("",ModeloRespostaUsuario.class);

        assertAll("Validacões detalhadas do login",
                () -> assertNotNull(usuario.getAccessToken(), "Token de acesso não pode ser nulo"),
                () -> assertTrue(usuario.getUsername().length() > 0, "Username não deve estar vazio")
                );
    }
}
