package com.thiago.chamados_api.dto.mapper;

import com.thiago.chamados_api.dto.ChamadoCreateDto;
import com.thiago.chamados_api.entity.Chamado;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
public class ChamadoMapper {

    public static Chamado toChamado(ChamadoCreateDto dto){
        return new ModelMapper().map(dto, Chamado.class);
    }
}
