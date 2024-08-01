package com.api.aula_crud.repository;

import com.api.aula_crud.classes.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {
    ContaBancaria findByNumeroConta(String numeroConta);
}
