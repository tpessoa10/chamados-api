package com.thiago.chamados_api.specification;

import com.thiago.chamados_api.dto.ChamadoFiltroRequest;
import com.thiago.chamados_api.entity.Chamado;
import org.springframework.data.jpa.domain.Specification;

public class ChamadoSpecification {

    public static Specification<Chamado> comFiltros(ChamadoFiltroRequest filtro){
        return Specification.where(tituloContem(filtro.titulo()));
    }

    private static Specification<Chamado> tituloContem(String titulo) {
        return (root, query,  cb) -> {
            if (titulo == null || titulo.isBlank()) {
                return null;
            }

            return cb.like(cb.lower(root.get("titulo")), "%" + titulo.toLowerCase() + "%");
        };
    }
}
