package contrato;

import br.com.dummy.base.BaseTeste;
import br.com.dummy.modelos.requisicao.ModeloRequisicaoUsuario;
import io.qameta.allure.Feature;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static br.com.dummy.cliente.ClienteLogin.autenticarUsuario;
import static br.com.dummy.fabrica.FabricaLogin.dadosLoginInvalido;
import static br.com.dummy.fabrica.FabricaLogin.dadosLoginValido;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TesteContratoLogin extends BaseTeste {
    @Test
    @DisplayName("Deve validar o contrato de login com credenciais válidas")
    @Feature("TesteContratoLogin")
    public void deveValidarContratoLoginComCredenciaisValidas(){
        ModeloRequisicaoUsuario usuarioValido = dadosLoginValido();

        autenticarUsuario(configuracaoRequisicao, configuracaoResposta, usuarioValido).
                statusCode(HttpStatus.SC_OK).
                body(matchesJsonSchemaInClasspath("schemas/loginOk.json"));

    }

    @Test
    @DisplayName("Deve validar o contrato de login com credenciais inválidas e retornar erro de autenticação")
    @Feature("TesteContratoLogin")
    public void deveValidarContratoLoginComCredenciaisInvalidas(){
        ModeloRequisicaoUsuario usuarioValido = dadosLoginInvalido();

        autenticarUsuario(configuracaoRequisicao, configuracaoResposta, usuarioValido).
                statusCode(HttpStatus.SC_BAD_REQUEST).
                body(matchesJsonSchemaInClasspath("schemas/loginBadRequest.json"));
    }
}
