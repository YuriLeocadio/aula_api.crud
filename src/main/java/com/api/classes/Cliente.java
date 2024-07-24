package com.api.classes;

import java.util.ArrayList;
import java.util.UUID;

import lombok.Data;

@Data
public class Cliente {
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    
    private UUID id = UUID.randomUUID();
    private String nome;
    private String cpf;
    private Endereco endereco;
    private String telefone;
    private String email;
    private String dataNascimento;
}
