package com.sicjac.sistemacontable.controller;

import com.sicjac.sistemacontable.model.Proveedor;
import com.sicjac.sistemacontable.service.ProveedorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
@Tag(name = "Proveedores", description = "Gestión de proveedores")
@CrossOrigin(origins = "*")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @Operation(summary = "Listar todos los proveedores")
    @GetMapping
    public List<Proveedor> listar() {
        return proveedorService.listarTodos();
    }

    @Operation(summary = "Obtener un proveedor por ID")
    @GetMapping("/{id}")
    public Proveedor obtener(@PathVariable Long id) {
        return proveedorService.buscarPorId(id);
    }

    @Operation(summary = "Crear un nuevo proveedor")
    @PostMapping
    public Proveedor crear(@RequestBody Proveedor proveedor) {
        return proveedorService.guardar(proveedor);
    }

    @Operation(summary = "Actualizar un proveedor existente")
    @PutMapping("/{id}")
    public Proveedor actualizar(@PathVariable Long id, @RequestBody Proveedor proveedor) {
        return proveedorService.actualizar(id, proveedor);
    }

    @Operation(summary = "Eliminar un proveedor")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        proveedorService.eliminar(id);
    }
}