package com.thiago.chamados_api.dto;

import com.thiago.chamados_api.enums.ChamadoCategoria;
import com.thiago.chamados_api.enums.ChamadoPrioridade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ChamadoUpdateDto {
    private String titulo;
    private String descricao;
    private ChamadoPrioridade chamadoPrioridade;
    private ChamadoCategoria chamadoCategoria;
}
