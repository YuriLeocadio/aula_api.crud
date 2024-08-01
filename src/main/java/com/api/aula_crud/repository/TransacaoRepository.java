package com.api.aula_crud.repository;

import com.api.aula_crud.classes.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findTransacoesByContaOrderByDataHora(String numeroConta);
}
