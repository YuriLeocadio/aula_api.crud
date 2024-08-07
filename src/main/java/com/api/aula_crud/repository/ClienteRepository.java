package com.api.aula_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.aula_crud.classes.Cliente;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByClienteAtivoTrue();
    List<Cliente> findByClienteAtivoFalse();
}
