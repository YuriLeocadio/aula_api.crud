package com.api.aula_crud.service;

import com.api.aula_crud.classes.ContaBancaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.aula_crud.classes.Transacao;
import com.api.aula_crud.repository.TransacaoRepository;
import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ContaBancariaService contaBancariaService;

    public List<Transacao> getAll() {
        return transacaoRepository.findAll();
    }

    public Transacao addTransacao(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    public List<Transacao> getExtrato(String numeroConta){
        return transacaoRepository.findByContaOrigemNumeroContaOrderByDataHoraDesc(numeroConta);
    }

    public Transacao criarTransacao(String contaOrigem, String contaDestino, double valor, String tipo) {
        ContaBancaria origem = contaBancariaService.getByNumeroConta(contaOrigem);
        ContaBancaria destino = contaBancariaService.getByNumeroConta(contaDestino);
        if (origem == null || destino == null) {
            throw new IllegalArgumentException("Conta de origem ou destino não encontrada.");
        }

        if (!contaBancariaService.verificarSaldoSuficiente(contaOrigem, valor)) {
            throw new IllegalArgumentException("Saldo insuficiente na conta de origem.");
        }

        origem.setSaldo(origem.getSaldo() - valor);
        destino.setSaldo(destino.getSaldo() + valor);
        contaBancariaService.addContaBancaria(origem);
        contaBancariaService.addContaBancaria(destino);

        Transacao novaTransacao = new Transacao();
        novaTransacao.setContaOrigem(origem);
        novaTransacao.setContaDestino(destino);
        novaTransacao.setValor(valor);
        novaTransacao.setTipo(tipo);
        novaTransacao.setDataHora(java.time.LocalDateTime.now());

        return addTransacao(novaTransacao);
    }

}