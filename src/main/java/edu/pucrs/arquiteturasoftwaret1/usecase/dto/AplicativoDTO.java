package edu.pucrs.arquiteturasoftwaret1.usecase.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AplicativoDTO {

    private long codigo;
    private String nome;
    private Double custo;
}
