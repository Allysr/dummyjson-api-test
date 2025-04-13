package funcional;

import br.com.dummy.base.BaseTeste;
import br.com.dummy.modelos.requisicao.ModeloRequisicaoUsuario;
import br.com.dummy.modelos.resposta.ModeloRespostaUsuario;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static br.com.dummy.cliente.ClienteLogin.autenticarUsuario;
import static br.com.dummy.fabrica.FabricaLogin.dadosLoginInvalido;
import static br.com.dummy.fabrica.FabricaLogin.dadosLoginValido;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

public class TesteLogin extends BaseTeste {

    @Test
    public void deveRealizarLoginObterToken(){
        ModeloRequisicaoUsuario usuarioValido = dadosLoginValido();

        ModeloRespostaUsuario usuario = autenticarUsuario(configuracaoRequisicao, configuracaoResposta, usuarioValido).
                statusCode(HttpStatus.SC_OK).
                extract().
                as(ModeloRespostaUsuario.class);

        assertAll("Validacões detalhadas do login",
                () -> assertNotNull(usuario.getAccessToken(), "Token de acesso não pode ser nulo"),
                () -> assertTrue(usuario.getUsername().length() > 0, "Username não deve estar vazio")
                );
    }

    @Test
    public void naoDeveRealizarLogin(){
        ModeloRequisicaoUsuario usuarioValido = dadosLoginInvalido();

        autenticarUsuario(configuracaoRequisicao, configuracaoResposta, usuarioValido).
                statusCode(HttpStatus.SC_BAD_REQUEST).
                body("message", equalTo("Invalid credentials"));

    }
}
