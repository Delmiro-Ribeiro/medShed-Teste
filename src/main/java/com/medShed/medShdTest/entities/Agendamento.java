package com.medShed.medShdTest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medShed.medShdTest.entities.enums.StatusServico;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "tb_agendamento")
public class Agendamento implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private StatusServico status;

    @ManyToOne
    @JoinColumn(name = "id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id")
    private PrestadorServico prestadorServico;

    @ManyToOne
    @JoinColumn(name = "id")
    private Servico servico;


}
