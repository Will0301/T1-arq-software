package edu.pucrs.arquiteturasoftwaret1.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteModel {
    private long codigo;
    private String nome;
    private String email;
}
