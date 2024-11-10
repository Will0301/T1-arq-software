package edu.pucrs.arquiteturasoftwaret1.domain.entities;

import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.PagamentoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssinaturaModel {
    private long codigo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<String> appsCodes = new ArrayList<>();
    private PagamentoEntity pagamento;
}
