package com.api.aula_crud.controllers;

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

    @PostMapping("/transferencia")
public ResponseEntity<?>realizarTransferencia(@RequestBody Transacao transacao) {

        if (!transacaoService.verificarContasExistem(transacao.getContaOrigem().getNumeroConta(), transacao.getContaDestino().getNumeroConta())) {
            return ResponseEntity.badRequest().body("Conta de origem ou destino não encontrada.");
        }

        if (!transacaoService.verificarSaldoSuficiente(transacao.getContaOrigem().getNumeroConta(), transacao.getValor())) {
            return ResponseEntity.badRequest().body("Saldo insuficiente.");
        }

        Transacao novaTransacao;
        try {
            novaTransacao = transacaoService.criarTransacao(
                    transacao.getContaOrigem().getNumeroConta(),
                    transacao.getContaDestino().getNumeroConta(),
                    transacao.getValor(),
                    transacao.getTipo()
            );
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        return ResponseEntity.ok(novaTransacao);
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