package com.sicjac.sistemacontable.service;

import com.sicjac.sistemacontable.model.Producto;
import com.sicjac.sistemacontable.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto buscarPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }

    public Producto actualizar(Long id, Producto datosNuevos) {
        Producto existente = buscarPorId(id);
        if (existente == null) return null;
        existente.setNombre(datosNuevos.getNombre());
        existente.setDescripcion(datosNuevos.getDescripcion());
        existente.setPrecio(datosNuevos.getPrecio());
        existente.setStock(datosNuevos.getStock());
        return productoRepository.save(existente);
    }
}