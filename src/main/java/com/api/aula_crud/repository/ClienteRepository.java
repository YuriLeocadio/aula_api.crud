package com.api.aula_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.aula_crud.classes.Cliente;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByClienteAtivoTrue();
    List<Cliente> findByClienteAtivoFalse();

    /*@Query("SELECT new com.api.aula_crud.dto.ClienteDTO(c.id, c.nome) FROM Cliente c")
    List<Cliente> getClientesDTO();*/
}
