package br.com.dummy.fabrica;

import br.com.dummy.modelos.requisicao.ModeloRequisicaoProduto;

public class FabricaProduto {
    public static ModeloRequisicaoProduto dadosProduto(){
        return ModeloRequisicaoProduto.builder().
                title("Perfume Oil").
                description("Mega Discount, Impression of A...").
                price(13).
                discountPercentage(8.4).
                rating(4.26).
                stock(65).
                brand("Impression of Acqua Di Gio").
                category("fragrances").
                thumbnail("https://i.dummyjson.com/data/products/11/thumnail.jpg").
                build();
    }

    public static ModeloRequisicaoProduto atualizarDadosProduto(){
        return ModeloRequisicaoProduto.builder().
                title("Perfume Free Oil").
                price(130).
                brand("Impression of Acqua").
                build();
    }
}