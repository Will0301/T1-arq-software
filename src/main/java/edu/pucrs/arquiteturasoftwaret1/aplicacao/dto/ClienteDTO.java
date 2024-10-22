package edu.pucrs.arquiteturasoftwaret1.aplicacao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private long codigo;
    private String nome;
    private String email;
}
