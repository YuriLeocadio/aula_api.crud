package com.api.aula_crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.aula_crud.classes.Cliente;
import com.api.aula_crud.service.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<CLiente>> getAll() {
        return clienteService.getAll();
    }

    /*@PostMapping
    public String addCliente(@RequestBody Cliente novoCliente) {
        for (Cliente cliente : Cliente.clientes) {
            if (cliente.getCpf().equals(novoCliente.getCpf()) || 
                cliente.getTelefone().equals(novoCliente.getTelefone()) || 
                cliente.getEmail().equals(novoCliente.getEmail())) {
                    
                return "Erro: Cliente com CPF, telefone ou email já cadastrado.";
            }
        }

        Cliente.clientes.add(novoCliente);
        return "Cliente adicionado com sucesso!";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable UUID id) {
        Gson gson = new Gson();
        for (Cliente cliente : Cliente.clientes) {
            if (cliente.getId().equals(id)) {
                String resposta = gson.toJson(cliente);
                return resposta;
            }
        }
        return "Cliente não encontrado";
    }

    @DeleteMapping("/{id}")
    public String removerCliente(@PathVariable UUID id) {
        for (Cliente cliente : Cliente.clientes) {
            if (cliente.getId().equals(id)) {
                Cliente.clientes.remove(cliente);
                return "Cliente removido com sucesso";
            }
        }
        return "Cliente não encontrado";
    }

    @PutMapping("/{id}")
    public String atualizarCliente(@PathVariable UUID id, @RequestBody Cliente clienteAtualizado) {
        for (Cliente cliente : Cliente.clientes) {
            if (cliente.getId().equals(id)) {
                cliente.setNome(clienteAtualizado.getNome());
                cliente.setCpf(clienteAtualizado.getCpf());
                cliente.setEndereco(clienteAtualizado.getEndereco());
                cliente.setTelefone(clienteAtualizado.getTelefone());
                cliente.setEmail(clienteAtualizado.getEmail());
                cliente.setDataNascimento(clienteAtualizado.getDataNascimento());

                return "Cliente atualizado com sucesso!";
            }
        }
        return "Cliente não encontrado";
    }
*/
}