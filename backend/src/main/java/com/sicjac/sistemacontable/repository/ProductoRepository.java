package com.sicjac.sistemacontable.repository;

import com.sicjac.sistemacontable.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}