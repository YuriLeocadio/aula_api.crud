package com.api.aula_crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.aula_crud.classes.Transacao;
import com.api.aula_crud.service.TransacaoService;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    /*@PostMapping("/transferencia")
    public ResponseEntity<Transacao> realizarTransferencia() {
        // Verificar saldo no service
        // Realizar a transferência
    }*/

    /*@GetMapping("/historico/{numeroConta}")
        // Lógica para buscar histórico de transações
        // Imprimir histórico de transações*/
    }
