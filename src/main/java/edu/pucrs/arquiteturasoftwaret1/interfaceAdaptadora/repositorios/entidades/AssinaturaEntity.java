package edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssinaturaEntity {
    @Id
    private long codigo;
    @Column
    private LocalDate dataInicio;
    @Column
    private LocalDate dataFim;

    @Column
    private Long codigoCliente;

    @Column
    private Long codigoAplicativo;

    @ManyToOne
    @JoinColumn(name = "pagamento_id")
    private PagamentoEntity pagamento;
}
