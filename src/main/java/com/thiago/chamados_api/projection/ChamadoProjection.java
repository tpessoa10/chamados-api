package com.thiago.chamados_api.projection;

import com.thiago.chamados_api.enums.ChamadoCategoria;
import com.thiago.chamados_api.enums.ChamadoPrioridade;
import com.thiago.chamados_api.enums.ChamadoStatus;

public interface ChamadoProjection {
    Long getId();
    String getTitulo();
    String getDescricao();
    ChamadoCategoria getChamadoCategoria();
    ChamadoPrioridade  getChamadoPrioridade();
    ChamadoStatus getChamadoStatus();
}
