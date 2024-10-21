package edu.pucrs.arquiteturasoftwaret1.usecase.dto;

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
public class PagamentoDTO {
    private Long id;
    private String cupom;
    private BigDecimal valorPago;
    private LocalDate dataPagamento;
}
