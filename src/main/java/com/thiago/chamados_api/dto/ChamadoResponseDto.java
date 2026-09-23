package com.thiago.chamados_api.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChamadoResponseDto {

    private Long id;
    private String titulo;
    private String descricao;
}
