package com.api.aula_crud.service;

import com.api.aula_crud.classes.ContaBancaria;
import com.api.aula_crud.repository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContaBancariaService {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    public List<ContaBancaria> getAll() {
        return contaBancariaRepository.getAll();
    }

    public ContaBancaria getByNumeroConta(String numeroConta) {
        return contaBancariaRepository.findByNumeroConta(numeroConta);
    }

    public ContaBancaria addContaBancaria(ContaBancaria contaBancaria) {
        return contaBancariaRepository.save(contaBancaria);
    }

    public void deleteContaBancaria(Long id) {
        contaBancariaRepository.deleteById(id);
    }

}
