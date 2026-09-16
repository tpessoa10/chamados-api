package com.thiago.chamados_api.controller;

import com.thiago.chamados_api.dto.ChamadoCreateDto;
import com.thiago.chamados_api.dto.ChamadoResponseDto;
import com.thiago.chamados_api.dto.ChamadoUpdateDto;
import com.thiago.chamados_api.dto.mapper.ChamadoMapper;
import com.thiago.chamados_api.entity.Chamado;
import com.thiago.chamados_api.repository.ChamadoRepository;
import com.thiago.chamados_api.service.ChamadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ChamadoResponseDto> create(@RequestBody @Valid ChamadoCreateDto dto){
        Chamado chamado = ChamadoMapper.toChamado(dto);
        chamadoService.salvar(chamado);
        return ResponseEntity.status(HttpStatus.CREATED).body(ChamadoMapper.toDto(chamado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Valid Long id){
        chamadoService.excluirChamadoPorId(id);
        return ResponseEntity.noContent().build();
    };

    @PutMapping("/{id}")
    public ResponseEntity<Chamado> update(@PathVariable @Valid Long id, @RequestBody @Valid ChamadoUpdateDto dto){
        Chamado chamado = chamadoService.buscarPorId(id, dto);
        return ResponseEntity.ok(chamado);
    }
}
