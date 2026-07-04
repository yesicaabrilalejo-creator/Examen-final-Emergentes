package com.sicjac.sistemacontable.service;

import com.sicjac.sistemacontable.model.Cliente;
import com.sicjac.sistemacontable.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente actualizar(Long id, Cliente datosNuevos) {
        Cliente existente = buscarPorId(id);
        if (existente == null) return null;
        existente.setNombreCompleto(datosNuevos.getNombreCompleto());
        existente.setNit(datosNuevos.getNit());
        existente.setTelefono(datosNuevos.getTelefono());
        existente.setEmail(datosNuevos.getEmail());
        return clienteRepository.save(existente);
    }
}