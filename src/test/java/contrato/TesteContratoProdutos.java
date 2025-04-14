package contrato;

import br.com.dummy.base.BaseTeste;
import br.com.dummy.modelos.requisicao.ModeloRequisicaoProduto;
import io.qameta.allure.Feature;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static br.com.dummy.cliente.ClienteProdutos.*;
import static br.com.dummy.fabrica.FabricaProduto.atualizarDadosProduto;
import static br.com.dummy.fabrica.FabricaProduto.dadosProduto;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TesteContratoProdutos extends BaseTeste {

    @Test
    @DisplayName("Deve validar o contrato da lista de produtos com sucesso")
    @Feature("TesteContratoProdutos")
    public void deveValidarContratoListaDeProdutosComSucesso() {
        consultaProdutos(configuracaoRequisicao, configuracaoResposta).
                statusCode(HttpStatus.SC_OK).
                body(matchesJsonSchemaInClasspath("schemas/listaProdutosOk.json"));

    }

    @Test
    @DisplayName("Deve validar o contrato de criação de produto com sucesso")
    @Feature("TesteContratoProdutos")
    public void deveValidarContratoCriacaoProdutoComSucesso() {
        ModeloRequisicaoProduto dadosProduto = dadosProduto();

        criarProdutos(configuracaoRequisicao, configuracaoResposta, dadosProduto).
                statusCode(HttpStatus.SC_CREATED).
                body(matchesJsonSchemaInClasspath("schemas/produtoCreated.json"));
    }

    @Test
    @DisplayName("Deve validar o contrato de atualização de produto com sucesso")
    @Feature("TesteContratoProdutos")
    public void deveValidarContratoAtualizacaoProdutoComSucesso() {
        ModeloRequisicaoProduto atualizarDadosProduto = atualizarDadosProduto();

        atualizarProduto(configuracaoRequisicao, configuracaoResposta, atualizarDadosProduto).
                statusCode(HttpStatus.SC_OK).
                body(matchesJsonSchemaInClasspath("schemas/produtoOk.json"));

    }

    @Test
    @DisplayName("Deve validar o contrato de deleção de produto com sucesso")
    @Feature("TesteContratoProdutos")
    public void deveValidarContratoDelecaoProdutoComSucesso() {
        deletarProduto(configuracaoRequisicao, configuracaoResposta).
                statusCode(HttpStatus.SC_OK).
                body(matchesJsonSchemaInClasspath("schemas/deletarProdutoOk.json"));
    }

}
