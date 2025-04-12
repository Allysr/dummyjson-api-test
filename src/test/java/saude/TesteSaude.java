package saude;

import br.com.dummy.base.BaseTeste;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static br.com.dummy.cliente.ClienteSaude.consultaSaudeDaApi;
import static org.hamcrest.Matchers.is;

public class TesteSaude extends BaseTeste {

    @Test
    @DisplayName("Deve validar a saude da api retornando status 200")
    public void deveValidarSaudeApi(){
        consultaSaudeDaApi(configuracaoRequisicao)
                .then()
                .spec(configuracaoResposta)
                .statusCode(HttpStatus.SC_OK)
                .body("status", is("ok"));
    }
}
