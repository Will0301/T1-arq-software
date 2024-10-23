package edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity {
    @Id
    private long codigo;
    @Column
    private String nome;
    @Column
    private String email;

    @ManyToOne
    @JoinColumn(name = "pagamento_id")
    private PagamentoEntity pagamento;

    @ManyToOne
    @JoinColumn(name = "assinatura_id")
    private AssinaturaEntity assinatura;

}
