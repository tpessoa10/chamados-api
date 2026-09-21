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

    @NotBlank(message = "Campo não deve ser vazio ou nulo!")
    private String titulo;
    @NotBlank(message = "Campo não deve ser vazio ou nulo!")
    private String descricao;
    @NotNull(message = "Campo não deve ser vazio ou nulo!")
    private ChamadoPrioridade chamadoPrioridade;
    @NotNull(message = "Campo não deve ser vazio ou nulo!")
    private ChamadoCategoria chamadoCategoria;
}
