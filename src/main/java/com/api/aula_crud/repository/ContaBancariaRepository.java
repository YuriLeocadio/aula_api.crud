package com.api.aula_crud.repository;

import com.api.aula_crud.classes.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {
    ContaBancaria findByNumeroConta(String numeroConta);
    List<ContaBancaria> getAll();
}
