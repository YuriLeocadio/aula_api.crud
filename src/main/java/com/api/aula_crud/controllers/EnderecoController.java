package com.api.aula_crud.controllers;

import com.api.aula_crud.classes.Endereco;
import com.api.aula_crud.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> getAll() {
        return ResponseEntity.ok(enderecoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getById(@PathVariable long id) {
        return ResponseEntity.ok(enderecoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Endereco> addEndereco(@RequestBody Endereco endereco) {
        return ResponseEntity.ok(enderecoService.addEndereco(endereco));
    }

    @PostMapping("/cep/{cep}")
    public ResponseEntity<Endereco> addEnderecoByCep(@PathVariable String cep) {
        return ResponseEntity.ok(enderecoService.getEnderecoByCep(cep));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> update(@PathVariable long id, @RequestBody Endereco endereco) {
        return ResponseEntity.ok(enderecoService.update(id, endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Endereco> delete(@PathVariable long id) {
        enderecoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
