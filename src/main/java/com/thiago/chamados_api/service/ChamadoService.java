package com.thiago.chamados_api.service;

import com.thiago.chamados_api.dto.ChamadoUpdateDto;
import com.thiago.chamados_api.entity.Chamado;
import com.thiago.chamados_api.repository.ChamadoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChamadoService {

    private final ChamadoRepository chamadoRepository;

    public Chamado salvar(Chamado chamado){
        return chamadoRepository.save(chamado);
    }

    public List<Chamado> buscarTodos(){
        return chamadoRepository.findAll();
    }

    public void excluirChamadoPorId(Long id){
        chamadoRepository.deleteById(id);
    }

    public Chamado buscarPorId(Long id, ChamadoUpdateDto dto) {
        Chamado chamado = chamadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));

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
