package com.api.classes;

import lombok.Data;

@Data
public class Endereco {

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String complemento;
}
