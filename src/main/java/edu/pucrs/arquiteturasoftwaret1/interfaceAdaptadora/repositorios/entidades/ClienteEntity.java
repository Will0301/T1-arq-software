package edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @ElementCollection
    @Builder.Default
    private List<Long> assinatura;

}
