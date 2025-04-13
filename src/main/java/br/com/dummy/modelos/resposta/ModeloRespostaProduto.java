package br.com.dummy.modelos.resposta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModeloRespostaProduto {
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
    private ModeloRespostaProduto meta;
    private List<String> images;
    private String thumbnail;
}

