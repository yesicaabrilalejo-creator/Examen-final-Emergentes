package com.sicjac.sistemacontable.controller;

import com.sicjac.sistemacontable.model.Cliente;
import com.sicjac.sistemacontable.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Clientes", description = "Gestión de clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Operation(summary = "Listar todos los clientes")
    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listarTodos();
    }

    @Operation(summary = "Obtener un cliente por ID")
    @GetMapping("/{id}")
    public Cliente obtener(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @Operation(summary = "Crear un nuevo cliente")
    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente) {
        return clienteService.guardar(cliente);
    }

    @Operation(summary = "Actualizar un cliente existente")
    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.actualizar(id, cliente);
    }

    @Operation(summary = "Eliminar un cliente")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        clienteService.eliminar(id);
    }
}
