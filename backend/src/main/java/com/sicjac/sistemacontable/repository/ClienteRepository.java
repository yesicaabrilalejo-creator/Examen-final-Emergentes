package com.sicjac.sistemacontable.repository;

import com.sicjac.sistemacontable.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
