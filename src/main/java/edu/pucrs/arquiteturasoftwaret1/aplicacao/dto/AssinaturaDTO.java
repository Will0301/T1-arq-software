package edu.pucrs.arquiteturasoftwaret1.aplicacao.dto;

import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.PagamentoEntity;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class AssinaturaDTO {
    private long codigo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<String> appsCodes = new ArrayList<>();
    private PagamentoEntity pagamento;
}
