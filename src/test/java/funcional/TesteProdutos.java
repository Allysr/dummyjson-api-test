package funcional;

import br.com.dummy.base.BaseTeste;
import br.com.dummy.modelos.resposta.ModeloRespostaProduto;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static br.com.dummy.cliente.ClienteProdutos.consultaProdutos;
import static org.junit.jupiter.api.Assertions.*;

public class TesteProdutos extends BaseTeste {

    @Test
    public void validarListaProdutos(){
       List<ModeloRespostaProduto> produtos = consultaProdutos(configuracaoRequisicao).
               then().
               spec(configuracaoResposta).
               statusCode(HttpStatus.SC_OK).
               extract().
               body().
               jsonPath().
               getList("products", ModeloRespostaProduto.class);


        assertAll("Validações detalhadas da lista de produtos",
                () -> assertFalse(produtos.isEmpty(), "A lista de produtos não deve estar vazia"),
                () -> assertTrue(produtos.size() > 1, "A lista deve ter mais de um produto"),
                () -> produtos.forEach(produto -> {
                    assertNotNull(produto.getId(), "O id do produto não pode ser nulo");
                })
        );

    }
}
