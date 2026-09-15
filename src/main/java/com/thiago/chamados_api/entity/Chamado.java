package com.thiago.chamados_api.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.thiago.chamados_api.enums.ChamadoCategoria;
import com.thiago.chamados_api.enums.ChamadoPrioridade;
import com.thiago.chamados_api.enums.ChamadoStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chamados")
@EntityListeners(AuditingEntityListener.class)
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descricao")
    private String descricao;
    @CreatedDate
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataCriacao;
    @Enumerated(EnumType.STRING)
    private ChamadoCategoria chamadoCategoria;
    @Enumerated(EnumType.STRING)
    private ChamadoPrioridade chamadoPrioridade;
    @Enumerated(EnumType.STRING)
    private ChamadoStatus chamadoStatus = ChamadoStatus.ABERTO;
}
