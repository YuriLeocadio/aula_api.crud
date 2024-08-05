package com.api.aula_crud.repository;

import com.api.aula_crud.classes.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
