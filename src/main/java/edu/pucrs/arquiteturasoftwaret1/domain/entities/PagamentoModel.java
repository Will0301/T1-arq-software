package edu.pucrs.arquiteturasoftwaret1.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoModel {
    private Long id;
    private String cupom;
    private BigDecimal valorPago;
    private LocalDate dataPagamento;
}
