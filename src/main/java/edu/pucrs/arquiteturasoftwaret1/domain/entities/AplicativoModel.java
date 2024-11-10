package edu.pucrs.arquiteturasoftwaret1.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AplicativoModel {

    private long codigo;
    private String nome;
    private Double custo;
}
