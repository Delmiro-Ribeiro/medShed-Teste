package com.medShed.medShdTest.entities;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "tb_prestador_servico")
public class PrestadorServico implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String especialidade;

    @OneToMany(mappedBy = "prestadorServico", cascade = CascadeType.ALL)
    private List<Agendamento> agendamentos = new ArrayList<>();

}
