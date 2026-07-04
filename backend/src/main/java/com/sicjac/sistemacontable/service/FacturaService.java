package com.sicjac.sistemacontable.service;

import com.sicjac.sistemacontable.model.Factura;
import com.sicjac.sistemacontable.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public List<Factura> listarTodas() {
        return facturaRepository.findAll();
    }

    public Factura guardar(Factura factura) {
        return facturaRepository.save(factura);
    }

    public Factura buscarPorId(Long id) {
        return facturaRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        facturaRepository.deleteById(id);
    }

    public Factura actualizar(Long id, Factura datosNuevos) {
        Factura existente = buscarPorId(id);
        if (existente == null) return null;
        existente.setNumeroFactura(datosNuevos.getNumeroFactura());
        existente.setFecha(datosNuevos.getFecha());
        existente.setClienteId(datosNuevos.getClienteId());
        existente.setTotal(datosNuevos.getTotal());
        return facturaRepository.save(existente);
    }
}
