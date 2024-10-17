package com.medShed.medShdTest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
@Table(name = "tb_servico")
public class Servico implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    private Duration duracao;
    private Double preco;

    private List<PrestadorServico> prestadorServicos = new ArrayList<>();




}
