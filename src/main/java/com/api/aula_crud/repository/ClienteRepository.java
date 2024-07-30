package com.api.aula_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.aula_crud.classes.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
