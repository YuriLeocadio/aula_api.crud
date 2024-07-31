package com.api.aula_crud.classes;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "contas_bancarias")
public class ContaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numeroConta;

    @OneToOne
    @JoinColumn(name = "Cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @Column(nullable = false)
    private double saldo;
}
