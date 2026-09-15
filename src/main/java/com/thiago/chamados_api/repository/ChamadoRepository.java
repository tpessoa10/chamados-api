package com.thiago.chamados_api.repository;

import com.thiago.chamados_api.entity.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
}
