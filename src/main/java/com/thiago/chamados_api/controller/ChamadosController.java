package com.thiago.chamados_api.controller;

import com.thiago.chamados_api.dto.ChamadoCreateDto;
import com.thiago.chamados_api.dto.mapper.ChamadoMapper;
import com.thiago.chamados_api.entity.Chamado;
import com.thiago.chamados_api.repository.ChamadoRepository;
import com.thiago.chamados_api.service.ChamadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/chamados")
@RequiredArgsConstructor
public class ChamadosController {

    @Autowired
    private ChamadoService chamadoService;

    @GetMapping
    public List<Chamado> getAll(){
        List<Chamado> chamados = chamadoService.buscarTodos();
        return chamados;
    }

    @PostMapping
    public void create(@RequestBody @Valid ChamadoCreateDto dto){
        Chamado chamado = ChamadoMapper.toChamado(dto);
        chamadoService.salvar(chamado);
    }
}
