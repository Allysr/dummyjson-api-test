package funcional;

import br.com.dummy.base.BaseTeste;
import br.com.dummy.modelos.requisicao.ModeloRequisicaoProduto;
import br.com.dummy.modelos.requisicao.ModeloRequisicaoUsuario;
import br.com.dummy.modelos.resposta.ModeloRespostaProduto;
import br.com.dummy.modelos.resposta.ModeloRespostaProdutoDeletado;
import br.com.dummy.modelos.resposta.listaProdutos.ModeloRespostaListaProdutos;
import io.qameta.allure.Feature;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static br.com.dummy.cliente.ClienteProdutos.*;
import static br.com.dummy.fabrica.FabricaLogin.dadosLoginValido;
import static br.com.dummy.fabrica.FabricaProduto.atualizarDadosProduto;
import static br.com.dummy.fabrica.FabricaProduto.dadosProduto;
import static br.com.dummy.util.EvidenciasUtils.anexarJsonAoReporte;
import static br.com.dummy.util.ObterToken.obterTokenLogin;
import static org.junit.jupiter.api.Assertions.*;

public class TesteProdutos extends BaseTeste {
    List<ModeloRespostaListaProdutos> produtos;
    ModeloRespostaProduto produto;
    ModeloRespostaProdutoDeletado produtoDeletado;

    @Test
    @DisplayName("Deve retornar a lista de produtos com sucesso")
    @Feature("TesteFuncionalProdutos")
    public void deveRetornarListaDeProdutosComSucesso(){
       produtos = consultaProdutos(configuracaoRequisicao, configuracaoResposta).
               statusCode(HttpStatus.SC_OK).
               extract().
               jsonPath().
               getList("products", ModeloRespostaListaProdutos.class);

        anexarJsonAoReporte(produtos);

        assertAll("Validações detalhadas da lista de produtos",
                () -> assertFalse(produtos.isEmpty(), "A lista de produtos não deve estar vazia"),
                () -> assertTrue(produtos.size() > 1, "A lista deve ter mais de um produto"),
                () -> produtos.forEach(produto -> {
                    assertNotNull(produto.getId(), "O id do produto não pode ser nulo");
                })
        );

    }

    @Test
    @DisplayName("Deve retornar a lista de produtos com sucesso para usuário autenticado")
    @Feature("TesteFuncionalProdutos")
    public void deveRetornarListaDeProdutosComUsuarioAutenticado(){
        ModeloRequisicaoUsuario usuarioValido = dadosLoginValido();
        String token =  obterTokenLogin(configuracaoRequisicao, usuarioValido);

        produtos = consultaProdutosComAutenticacao(configuracaoRequisicao,configuracaoResposta, token).
                statusCode(HttpStatus.SC_OK).
                extract().
                jsonPath().
                getList("products", ModeloRespostaListaProdutos.class);

        anexarJsonAoReporte(produtos);

        assertAll("Validações detalhadas da lista de produtos",
                () -> assertFalse(produtos.isEmpty(), "A lista de produtos não deve estar vazia"),
                () -> assertTrue(produtos.size() > 1, "A lista deve ter mais de um produto"),
                () -> produtos.forEach(produto -> {
                    assertNotNull(produto.getId(), "O id do produto não pode ser nulo");
                })
        );
    }

    @Test
    @DisplayName("Deve criar um produto com sucesso")
    @Feature("TesteFuncionalProdutos")
    public void deveCriarProdutoComSucesso(){
        ModeloRequisicaoProduto dadosProduto = dadosProduto();

        produto = criarProdutos(configuracaoRequisicao, configuracaoResposta, dadosProduto).
                statusCode(HttpStatus.SC_CREATED).
                extract().
                as(ModeloRespostaProduto.class);

        anexarJsonAoReporte(produto);

        assertAll("Validação do produto criado",
                () -> assertNotNull(produto.getId(), "O ID do produto não pode ser nulo"),
                () -> assertEquals(dadosProduto.getTitle(), produto.getTitle(), "Título diferente"),
                () -> assertEquals(dadosProduto.getDescription(), produto.getDescription(), "Descrição diferente"),
                () -> assertEquals(dadosProduto.getPrice(), produto.getPrice(), "Preço diferente"),
                () -> assertEquals(dadosProduto.getDiscountPercentage(), produto.getDiscountPercentage(),  "Desconto diferente"),
                () -> assertEquals(dadosProduto.getRating(), produto.getRating(),  "Avaliação diferente"),
                () -> assertEquals(dadosProduto.getStock(), produto.getStock(), "Estoque diferente"),
                () -> assertEquals(dadosProduto.getBrand(), produto.getBrand(), "Marca diferente"),
                () -> assertEquals(dadosProduto.getCategory(), produto.getCategory(), "Categoria diferente"),
                () -> assertEquals(dadosProduto.getThumbnail(), produto.getThumbnail(), "Thumbnail diferente")
        );


    }

    @Test
    @DisplayName("Deve atualizar o produto com sucesso")
    @Feature("TesteFuncionalProdutos")
    public void deveAtualizarProdutoComSucesso(){
        ModeloRequisicaoProduto atualizarDadosProduto = atualizarDadosProduto();

        produto = atualizarProduto(configuracaoRequisicao, configuracaoResposta, atualizarDadosProduto).
                statusCode(HttpStatus.SC_OK).
                extract().
                as(ModeloRespostaProduto.class);

        anexarJsonAoReporte(produto);

        assertAll("Validação do produto criado",
                () -> assertEquals(atualizarDadosProduto.getTitle(), produto.getTitle(), "Título diferente"),
                () -> assertEquals(atualizarDadosProduto.getPrice(), produto.getPrice(), "Preço diferente"),
                () -> assertEquals(atualizarDadosProduto.getBrand(), produto.getBrand(), "Marca diferente")
        );
    }

    @Test
    @DisplayName("Deve deletar o produto com sucesso")
    @Feature("TesteFuncionalProdutos")
    public void deveDeletarProdutoComSucesso(){
        produtoDeletado = deletarProduto(configuracaoRequisicao, configuracaoResposta).
                statusCode(HttpStatus.SC_OK).
                extract().
                as(ModeloRespostaProdutoDeletado.class);

        anexarJsonAoReporte(produtoDeletado);

        assertAll("Validação do produto deletado",
                () -> assertTrue(produtoDeletado.getIsDeleted(), "O produto não foi marcado como deletado"),
                () -> assertNotNull(produtoDeletado.getDeletedOn(), "A data de deleção não foi registrada")
        );
    }
}
