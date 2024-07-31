package com.api.aula_crud.classes;

import  lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transacoes")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "conta_origem_id", referencedColumnName = "id")
    private ContaBancaria contaOrigem;

    @OneToOne
    @JoinColumn(name = "conta_destino_id", referencedColumnName = "id")
    private ContaBancaria contaDestino;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private LocalDateTime dataHora;
}
