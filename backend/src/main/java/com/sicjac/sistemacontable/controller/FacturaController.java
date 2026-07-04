package com.sicjac.sistemacontable.controller;

import com.sicjac.sistemacontable.model.Factura;
import com.sicjac.sistemacontable.service.FacturaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
@Tag(name = "Facturas", description = "Gestión de facturas de venta")
@CrossOrigin(origins = "*")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @Operation(summary = "Listar todas las facturas")
    @GetMapping
    public List<Factura> listar() {
        return facturaService.listarTodas();
    }

    @Operation(summary = "Obtener una factura por ID")
    @GetMapping("/{id}")
    public Factura obtener(@PathVariable Long id) {
        return facturaService.buscarPorId(id);
    }

    @Operation(summary = "Crear una nueva factura")
    @PostMapping
    public Factura crear(@RequestBody Factura factura) {
        return facturaService.guardar(factura);
    }

    @Operation(summary = "Actualizar una factura existente")
    @PutMapping("/{id}")
    public Factura actualizar(@PathVariable Long id, @RequestBody Factura factura) {
        return facturaService.actualizar(id, factura);
    }

    @Operation(summary = "Eliminar una factura")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        facturaService.eliminar(id);
    }
}
