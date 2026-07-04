package com.sicjac.sistemacontable.repository;

import com.sicjac.sistemacontable.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
