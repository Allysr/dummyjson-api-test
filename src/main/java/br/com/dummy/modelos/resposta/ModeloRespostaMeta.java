package br.com.dummy.modelos.resposta;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ModeloRespostaMeta {
    private String createdAt;
    private String updatedAt;
    private String barcode;
    private String qrCode;
}
