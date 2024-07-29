package com.api.aula_crud.controllers;

import com.api.aula_crud.classes.Cliente;
import com.google.gson.Gson;
import java.util.UUID;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    /*@GetMapping
    public String getAllClientes() {
        Gson gson = new Gson();

        if (!Cliente.clientes.isEmpty()) {
            String resposta = gson.toJson(Cliente.clientes);
            return resposta;
        } else {
            return "Não há clientes cadastrados.";
        }
    }

    @PostMapping
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