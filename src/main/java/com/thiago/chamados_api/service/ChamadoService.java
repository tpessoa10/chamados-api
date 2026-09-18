package com.thiago.chamados_api.service;

import com.thiago.chamados_api.dto.ChamadoUpdateDto;
import com.thiago.chamados_api.entity.Chamado;
import com.thiago.chamados_api.exceptions.EntityNotFoundException;
import com.thiago.chamados_api.projection.ChamadoProjection;
import com.thiago.chamados_api.repository.ChamadoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChamadoService {

    private final ChamadoRepository chamadoRepository;

    public Chamado salvar(Chamado chamado){
        return chamadoRepository.save(chamado);
    }

    public Page<ChamadoProjection> buscarTodos(Pageable pageable){
        return chamadoRepository.finAllPageable(pageable);
    }

    public void excluirChamadoPorId(Long id){
        Chamado chamado = chamadoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Chamado", id.toString())
        );
        chamadoRepository.delete(chamado);
    }

    public Chamado buscarPorId(Long id, ChamadoUpdateDto dto) {
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Chamado", id.toString()));

        if (dto.getChamadoCategoria() != null) {
            chamado.setChamadoCategoria(dto.getChamadoCategoria());
        }

        if (dto.getChamadoPrioridade() != null) {
            chamado.setChamadoPrioridade(dto.getChamadoPrioridade());
        }

        if (dto.getDescricao() != null && !dto.getDescricao().isBlank()) {
            chamado.setDescricao(dto.getDescricao());
        }

        if (dto.getTitulo() != null && !dto.getTitulo().isBlank()) {
            chamado.setTitulo(dto.getTitulo());
        }
        return chamadoRepository.save(chamado);
    }
}
