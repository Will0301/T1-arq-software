package edu.pucrs.arquiteturasoftwaret1.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AplicativoEntity {
    private long codigo;
    private String nome;
    private Double custo;
}
