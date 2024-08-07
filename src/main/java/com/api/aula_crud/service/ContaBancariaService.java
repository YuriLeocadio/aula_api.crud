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
        return contaBancariaRepository.findAll();
    }

    public ContaBancaria getByNumeroConta(String numeroConta) {
        return contaBancariaRepository.findByNumeroConta(numeroConta);
    }

    public ContaBancaria addContaBancaria(ContaBancaria contaBancaria) {
        return contaBancariaRepository.save(contaBancaria);
    }

    public ContaBancaria deleteContaBancaria(Long id) {
        ContaBancaria conta = contaBancariaRepository.findById(id).get();
        contaBancariaRepository.delete(conta);
        return conta;
    }

    public double verificarSaldo(String numeroConta){
        ContaBancaria conta = contaBancariaRepository.findByNumeroConta(numeroConta);
        if(conta != null){
            return conta.getSaldo();
        }
        throw new IllegalArgumentException("Conta não encontrada");
    }

    public boolean verificarSaldoSuficiente(String contaOrigem, double valor) {
        ContaBancaria origem = getByNumeroConta(contaOrigem);
        return origem != null && origem.getSaldo() >= valor;
    }
}
