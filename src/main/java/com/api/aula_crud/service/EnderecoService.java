package com.api.aula_crud.service;

import com.api.aula_crud.repository.EnderecoRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.aula_crud.classes.Endereco;
import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    ViaCepService viaCepService;

    public List<Endereco> getAll(){
        return enderecoRepository.findAll();
    }

    public Endereco getById(Long id){
        return enderecoRepository.findById(id).orElse(null);
    }

    public Endereco getEnderecoByCep(String cep){
        System.out.println("Buscando endereco com CEP: "+cep);
        Endereco endereco = viaCepService.getEnderecoByCep(cep);

        // Remove o hifen do String cep
        endereco.setCep(endereco.getCep().replace("-", ""));

        Gson gson = new Gson();
        System.out.println("Endereco: "+gson.toJson(endereco));
        return enderecoRepository.save(endereco);
    }
    public Endereco addEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public Endereco update(Long id, Endereco endereco){
        endereco.setId(id);
        return enderecoRepository.save(endereco);
    }

    public Endereco delete(Long id){
        Endereco endereco = getById(id);
        enderecoRepository.delete(endereco);
        return endereco;
    }
}
