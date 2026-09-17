package com.thiago.chamados_api.repository;

import com.thiago.chamados_api.entity.Chamado;
import com.thiago.chamados_api.projection.ChamadoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
    @Query("select c from Chamado c")
    Page<ChamadoProjection> finAllPageable(Pageable pageable);
}
