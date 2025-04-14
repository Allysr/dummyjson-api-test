package funcional;

import br.com.dummy.base.BaseTeste;
import br.com.dummy.modelos.requisicao.ModeloRequisicaoUsuario;
import br.com.dummy.modelos.resposta.ModeloRespostaUsuario;
import io.qameta.allure.Feature;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static br.com.dummy.cliente.ClienteLogin.autenticarUsuario;
import static br.com.dummy.fabrica.FabricaLogin.dadosLoginValido;
import static br.com.dummy.util.EvidenciasUtils.anexarJsonAoReporte;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
public class TesteLogin extends BaseTeste {

    @Test
    @DisplayName("Deve realizar login e obter o token de acesso com sucesso")
    @Feature("TesteFuncionalLogin")
    public void deveRealizarLoginObterToken(){
        ModeloRequisicaoUsuario usuarioValido = dadosLoginValido();

        ModeloRespostaUsuario usuario = autenticarUsuario(configuracaoRequisicao, configuracaoResposta, usuarioValido).
                statusCode(HttpStatus.SC_OK).
                extract().
                as(ModeloRespostaUsuario.class);

        anexarJsonAoReporte(usuario);

        assertAll("Validacões detalhadas do login",
                () -> assertNotNull(usuario.getAccessToken(), "Token de acesso não pode ser nulo"),
                () -> assertTrue(usuario.getUsername().length() > 0, "Username não deve estar vazio")
                );

    }


    @ParameterizedTest(name = "Tentativa de login inválido #{index}")
    @DisplayName("Não deve realizar login com credenciais inválidas")
    @MethodSource("br.com.dummy.fabrica.FabricaLogin#dadosLoginsInvalidos")
    @Feature("TesteFuncionalLogin")
    public void naoDeveRealizarLogin(ModeloRequisicaoUsuario fornecerDadosLoginValido) {
        autenticarUsuario(configuracaoRequisicao, configuracaoResposta, fornecerDadosLoginValido)
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("message", equalTo("Invalid credentials"));

    }

}
