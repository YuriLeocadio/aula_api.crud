package com.api.controllers;



import com.api.classes.Cliente;
import java.util.UUID;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @GetMapping
    public String getAllClientes() {
        if (!Cliente.clientes.isEmpty()) {
            return Cliente.clientes.toString();
        } else {
            return "Não há clientes cadastrados.";
        }
    }

    @PostMapping
    public String addCliente(@RequestBody Cliente cliente) {

        System.out.println("Adicionando cliente...");

        Cliente.clientes.add(cliente);
        return "Cliente adicionado com sucesso!";
    }

    /*@DeleteMapping
    public String delCliente(@RequestBody UUID id) {
        Cliente.cliente
    }*/

    @GetMapping("{id}")
    public String getById(@RequestParam UUID id){
        for(Cliente cliente : Cliente.clientes){
            if (cliente.getId().equals(id)) {
                return cliente.toString();
            }
        }
        return "Cliente não encontrado";
    }
}