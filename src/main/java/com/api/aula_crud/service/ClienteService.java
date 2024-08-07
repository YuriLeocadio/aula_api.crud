package com.api.aula_crud.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.aula_crud.classes.Cliente;
import com.api.aula_crud.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public Cliente getById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente addCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente delete(Long id) {
        Cliente cliente = getById(id);
        cliente.setClienteAtivo(false);
        return clienteRepository.save(cliente);
    }

    public Cliente ativar(Long id){
        Cliente cliente = getById(id);
        cliente.setClienteAtivo(true);
        return clienteRepository.save(cliente);
    }

    public List<Cliente> getAllAtivos() {
        return clienteRepository.findByClienteAtivoTrue();
    }

    public List<Cliente> getAllInativos(){
        return clienteRepository.findByClienteAtivoFalse();
    }
    }
