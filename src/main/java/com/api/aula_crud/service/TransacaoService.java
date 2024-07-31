package com.api.aula_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.aula_crud.classes.Transacao;
import com.api.aula_crud.repository.TransacaoRepository;
import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    /*public List<Transacao> getAll() {
        return transacaoRepository.findAll();
    }*/

    public Transacao addTransacao(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }
    //getByConta (extrato) ordenar por ASC de data
}