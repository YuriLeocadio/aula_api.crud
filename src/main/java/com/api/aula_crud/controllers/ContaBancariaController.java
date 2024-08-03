package com.api.aula_crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.aula_crud.classes.ContaBancaria;
import com.api.aula_crud.service.ContaBancariaService;
import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaBancariaController {

    @Autowired
    private ContaBancariaService contaBancariaService;

    @GetMapping
    public ResponseEntity<List<ContaBancaria>> getAll() {
        List<ContaBancaria> contas = contaBancariaService.getAll();
        return ResponseEntity.ok(contas);
    }

    @PostMapping
    public ResponseEntity<ContaBancaria> addContaBancaria(@RequestBody ContaBancaria contaBancaria) {
        ContaBancaria contaSalva = contaBancariaService.addContaBancaria(contaBancaria);
        return ResponseEntity.ok(contaSalva);
    }

    @GetMapping("/{numeroConta}")
    public ResponseEntity<ContaBancaria> getByNumeroConta(@PathVariable String numeroConta) {
        ContaBancaria conta = contaBancariaService.getByNumeroConta(numeroConta);

        if (conta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(conta);
    }

    @PutMapping("/{numeroConta}")
    public ResponseEntity<ContaBancaria> update(@PathVariable String numeroConta, @RequestBody ContaBancaria conta) {
        ContaBancaria contaExistente = contaBancariaService.getByNumeroConta(numeroConta);

        if (contaExistente == null) {
            return ResponseEntity.notFound().build();
        }
        contaExistente.setSaldo(conta.getSaldo());
        contaExistente.setCliente(conta.getCliente());

        ContaBancaria contaSalva = contaBancariaService.addContaBancaria(contaExistente);
        return ResponseEntity.ok(contaSalva);
    }

    @DeleteMapping("/{numeroConta}")
    public ResponseEntity<ContaBancaria> delete(@PathVariable String numeroConta) {
        ContaBancaria conta = contaBancariaService.getByNumeroConta(numeroConta);

        if (conta == null) {
            return ResponseEntity.notFound().build();
        }
        contaBancariaService.deleteContaBancaria(conta.getId());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/saldo/{numeroConta}")
    public ResponseEntity<?> verificarSaldo(@PathVariable String numeroConta) {
        try {
            double saldo = contaBancariaService.verificarSaldo(numeroConta);
            return ResponseEntity.ok(saldo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
