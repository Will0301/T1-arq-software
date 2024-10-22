package edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
}
