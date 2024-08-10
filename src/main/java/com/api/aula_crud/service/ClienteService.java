package com.api.aula_crud.service;

import java.util.ArrayList;
import java.util.List;

import com.api.aula_crud.dto.ClienteDTO;
import com.api.aula_crud.dto.ClienteUpdateDTO;
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

    /*public ClienteUpdateDTO updateDTO(Cliente clienteExistente, ClienteUpdateDTO clienteNovo){
        // Converter o que é DTO pra Cliente

        if (clienteNovo.getNome() != null){
            clienteExistente.setNome(clienteNovo.getNome());
        }
        if (clienteNovo.getTelefone() != null){
            clienteExistente.setTelefone(clienteNovo.getTelefone());
        }
        if (clienteNovo.getEmail() != null){
            clienteExistente.setEmail(clienteNovo.getEmail());
        }

        // Atualizar o clienteExistente com os dados do clienteNovo
        Cliente clienteSalvo = clienteRepository.save(clienteExistente);

        // Converter o Cliente pra DTO
        ClienteUpdateDTO clienteDTO = new ClienteUpdateDTO();
        clienteDTO.setId(clienteSalvo.getId());
        clienteDTO.setNome(clienteSalvo.getNome());
        clienteDTO.setTelefone(clienteSalvo.getTelefone());
        clienteDTO.setEmail(clienteSalvo.getEmail());

        // Retornar
        return clienteDTO;
    }

    public List<ClienteDTO> getClientesDTO(){
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDTO> clientesDTO = new ArrayList<>();

        for (Cliente cliente : clientes){
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setId(cliente.getId());
            clienteDTO.setNome(cliente.getNome());

            clientesDTO.add(clienteDTO);
        }
        return clientesDTO;
    }*/
    }
