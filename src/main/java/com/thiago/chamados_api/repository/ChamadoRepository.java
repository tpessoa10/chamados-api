package com.thiago.chamados_api.repository;

import com.thiago.chamados_api.entity.Chamado;
import com.thiago.chamados_api.projection.ChamadoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChamadoRepository extends JpaRepository<Chamado, Long>, JpaSpecificationExecutor<Chamado> {
    @Query("""
        SELECT c
        FROM Chamado c
        WHERE LOWER(c.titulo) LIKE CONCAT('%', LOWER(COALESCE(:titulo, '')), '%')
    """)
    Page<ChamadoProjection> findAllPageable(@Param("titulo") String titulo, Pageable pageable);
}
