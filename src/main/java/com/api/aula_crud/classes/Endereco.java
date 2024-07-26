package com.api.aula_crud.classes;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 8)
    private String cep;

    private String logradouro;
    private String bairro;
    private String localidade;
    private String complemento;

    // Transformar em ENUM
    private String uf;
}
