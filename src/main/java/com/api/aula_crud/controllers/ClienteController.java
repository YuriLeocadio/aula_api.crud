package com.api.aula_crud.controllers;

import com.api.aula_crud.dto.ClienteDTO;
import com.api.aula_crud.dto.ClienteUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.aula_crud.classes.Cliente;
import com.api.aula_crud.service.ClienteService;
import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        List<Cliente> clientes = clienteService.getAll();
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteService.addCliente(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id) {
        Cliente cliente = clienteService.getById(id);

        if (cliente != null){
            return ResponseEntity.ok(cliente);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteExistente = clienteService.getById(id);

        if (clienteExistente == null){
            return ResponseEntity.notFound().build();
        }

        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setEmail(cliente.getEmail());
        clienteExistente.setTelefone(cliente.getTelefone());
        clienteExistente.setCpf(cliente.getCpf());
        clienteExistente.setEndereco(cliente.getEndereco());
        clienteExistente.setDataNascimento(cliente.getDataNascimento());

        Cliente clienteSalvo = clienteService.addCliente(clienteExistente);
        return ResponseEntity.ok(clienteSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable Long id) {
        Cliente cliente = clienteService.getById(id);

        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteService.delete(id));
    }

    @PutMapping("/ativar/{id}")
    public ResponseEntity<Cliente> edit(@PathVariable Long id) {
        Cliente cliente = clienteService.getById(id);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteService.ativar(id));
    }

    @GetMapping("/inativos")
    public ResponseEntity<List<Cliente>> getAllInativos() {
        List<Cliente> clientes = clienteService.getAllInativos();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<Cliente>> getAllAtivos() {
        List<Cliente> clientes = clienteService.getAllAtivos();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/nomes")
    public ResponseEntity<List<ClienteDTO>> getClientesDTO(){
        return ResponseEntity.ok(clienteService.getClientesDTO());
    }

    @PutMapping("/dto/{id}")
    public ResponseEntity<ClienteUpdateDTO> updateDTO(@PathVariable Long id, @RequestBody ClienteUpdateDTO clienteNovo) {
        Cliente clienteExistente = clienteService.getById(id);

        if(clienteExistente == null){
            return ResponseEntity.notFound().build();
        }

        ClienteUpdateDTO clienteDTO = clienteService.updateDTO(clienteExistente, clienteNovo);
        return ResponseEntity.ok(clienteDTO);
    }
}