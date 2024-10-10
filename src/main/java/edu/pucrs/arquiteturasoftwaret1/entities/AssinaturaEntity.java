package edu.pucrs.arquiteturasoftwaret1.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssinaturaEntity {
    private long codigo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}
