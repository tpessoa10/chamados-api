package com.thiago.chamados_api.dto;

import com.thiago.chamados_api.enums.ChamadoCategoria;
import com.thiago.chamados_api.enums.ChamadoPrioridade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChamadoCreateDto {

    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
    @NotNull
    private ChamadoPrioridade chamadoPrioridade;
    @NotNull
    private ChamadoCategoria chamadoCategoria;
}
