package com.sicjac.sistemacontable.service;

import com.sicjac.sistemacontable.model.Proveedor;
import com.sicjac.sistemacontable.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> listarTodos() {
        return proveedorRepository.findAll();
    }

    public Proveedor guardar(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Proveedor buscarPorId(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        proveedorRepository.deleteById(id);
    }

    public Proveedor actualizar(Long id, Proveedor datosNuevos) {
        Proveedor existente = buscarPorId(id);
        if (existente == null) return null;
        existente.setNombre(datosNuevos.getNombre());
        existente.setTelefono(datosNuevos.getTelefono());
        existente.setCorreo(datosNuevos.getCorreo());
        return proveedorRepository.save(existente);
    }
}