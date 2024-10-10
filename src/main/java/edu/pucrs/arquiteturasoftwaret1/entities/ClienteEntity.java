package edu.pucrs.arquiteturasoftwaret1.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity {
    private long codigo;
    private String nome;
    private String email;
}
