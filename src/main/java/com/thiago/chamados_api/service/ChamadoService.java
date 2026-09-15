package com.thiago.chamados_api.service;

import com.thiago.chamados_api.entity.Chamado;
import com.thiago.chamados_api.repository.ChamadoRepository;
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
}
