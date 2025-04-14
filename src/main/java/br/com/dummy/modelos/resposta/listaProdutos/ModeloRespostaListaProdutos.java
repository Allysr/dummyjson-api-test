package br.com.dummy.modelos.resposta.listaProdutos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModeloRespostaListaProdutos {
    private Integer id;
    private String title;
    private String description;
    private String category;
    private Double price;
    private Double discountPercentage;
    private Double rating;
    private Integer stock;
    private List<String> tags;
    private String brand;
    private String sku;
    private Integer weight;
    private ModeloRespostaDimensoes dimensions;
    private String warrantyInformation;
    private String shippingInformation;
    private String availabilityStatus;
    private List<ModeloRespostaReview> reviews;
    private String returnPolicy;
    private Integer minimumOrderQuantity;
    private ModeloRespostaMeta meta;
    private List<String> images;
    private String thumbnail;
}

