package com.api.aula_crud.controllers;

import com.api.aula_crud.service.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.aula_crud.classes.Transacao;
import com.api.aula_crud.service.TransacaoService;
import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;
    @Autowired
    private ContaBancariaService contaBancariaService;

    @PostMapping("/transferencia")
public ResponseEntity<?>realizarTransferencia(@RequestBody Transacao transacao) {
        try {
            Transacao novaTransacao = transacaoService.criarTransacao(
                    transacao.getContaOrigem().getNumeroConta(),
                    transacao.getContaDestino().getNumeroConta(),
                    transacao.getValor(),
                    transacao.getTipo()
            );
            return ResponseEntity.ok(novaTransacao);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/historico/{numeroConta}")
    public ResponseEntity<?> getHistoricoTransacoes(@PathVariable String numeroConta) {

        List<Transacao> transacoes = transacaoService.getExtrato(numeroConta);
        if (transacoes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(transacoes);
    }
}