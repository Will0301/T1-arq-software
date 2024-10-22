package edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AplicativoEntity {
    @Id
    private long codigo;
    @Column
    private String nome;
    @Column
    private Double custo;
}
