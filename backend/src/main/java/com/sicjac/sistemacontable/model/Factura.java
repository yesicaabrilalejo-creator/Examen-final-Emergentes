package com.sicjac.sistemacontable.model;

import jakarta.persistence.*;

@Entity
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroFactura;
    private String fecha;
    private Long clienteId;
    private Double total;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumeroFactura() { return numeroFactura; }
    public void setNumeroFactura(String numeroFactura) { this.numeroFactura = numeroFactura; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
}
