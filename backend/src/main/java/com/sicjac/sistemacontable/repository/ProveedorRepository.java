package com.sicjac.sistemacontable.repository;

import com.sicjac.sistemacontable.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}