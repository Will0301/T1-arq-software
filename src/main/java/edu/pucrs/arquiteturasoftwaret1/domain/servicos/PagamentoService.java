package edu.pucrs.arquiteturasoftwaret1.domain.servicos;

import edu.pucrs.arquiteturasoftwaret1.aplicacao.dto.PagamentoDTO;
import edu.pucrs.arquiteturasoftwaret1.domain.repository.IPagamentoRepository;
import edu.pucrs.arquiteturasoftwaret1.domain.servicos.mapper.PagamentoMapper;
import edu.pucrs.arquiteturasoftwaret1.interfaceAdaptadora.repositorios.entidades.PagamentoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final IPagamentoRepository pagamentoRepository;

    public PagamentoDTO registrarPagamento(PagamentoDTO pagamento){
        return PagamentoMapper.mapToDTO(pagamentoRepository.registrarPagamento(PagamentoMapper.mapToEntity(pagamento)));
    }
}