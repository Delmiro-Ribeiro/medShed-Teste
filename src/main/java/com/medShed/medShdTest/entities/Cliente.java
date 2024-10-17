package com.medShed.medShdTest.entities;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "tb_cliente")
public class Cliente implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Agendamento> agendamentos = new ArrayList<>();

    @OneToMany( cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

}
