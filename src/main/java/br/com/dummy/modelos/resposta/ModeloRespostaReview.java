package br.com.dummy.modelos.resposta;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ModeloRespostaReview {
    private Integer rating;
    private String comment;
    private String date;
    private String reviewerName;
    private String reviewerEmail;
}
