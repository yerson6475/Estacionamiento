package com.parqueadero.demo.modelo;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "registro")
public class Registrouno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "tipo", length = 7)
    private String tipo;

    @NotNull
    @Column(name = "placa", length = 7)
    private String placa;

    @NotNull
    @Column(name = "fecha_ingreso")
    private LocalDateTime fechaIngreso;

    @Column(name = "fecha_salida")
    private LocalDateTime fechaSalida;

    @Column(name = "total_pago")
    private BigDecimal totalPago;

    public Registrouno() {
    }

    public Registrouno(long id, String tipo, String placa, LocalDateTime fechaIngreso, LocalDateTime fechaSalida, BigDecimal totalPago) {
        this.id = id;
        this.tipo = tipo;
        this.placa = placa;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.totalPago = totalPago;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public BigDecimal getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(BigDecimal totalPago) {
        this.totalPago = totalPago;
    }
}
