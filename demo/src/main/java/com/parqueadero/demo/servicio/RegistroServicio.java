package com.parqueadero.demo.servicio;

import com.parqueadero.demo.modelo.Registrouno;
import com.parqueadero.demo.repositorio.RegistroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RegistroServicio {

    @Autowired
    RegistroRepositorio registroRepositorio;

    public Registrouno crear(Registrouno registrouno) {
        registrouno.setFechaIngreso(LocalDateTime.now());
        return registroRepositorio.save(registrouno);
    }

    public Registrouno actualizar(Long id) {
        Optional<Registrouno> registroOptional = this.registroRepositorio.findById(id);

        Registrouno registrouno = registroOptional.get();
        registrouno.setFechaSalida(LocalDateTime.now());
        registrouno.setTotalPago(obtenerTotalPagar(registrouno));
        return this.registroRepositorio.save(registrouno);

    }

    private BigDecimal obtenerTotalPagar(Registrouno registrouno) {

        BigDecimal totalPagar = BigDecimal.ZERO;
        Duration duracion = Duration.between(registrouno.getFechaIngreso(), registrouno.getFechaSalida());
        Long minutosParqueo = duracion.toMinutes();

        switch (registrouno.getTipo()) {

            case "carro":
                totalPagar = new BigDecimal(minutosParqueo * 500);
                break;
            case "moto":
                totalPagar = new BigDecimal(minutosParqueo * 300);
                break;
            default:
                break;
        }
        return totalPagar;

    }

    public List<Registrouno> listarVehiculos() {
        return  this.registroRepositorio.findByFechaSalidaIsNull();
    }

    public List<Registrouno> listarPorPlaca(String placa) {
        return this.registroRepositorio.findByPlaca(placa);
    }

    public void  eliminar(Long id) {
         this.registroRepositorio.deleteById(id);
    }
}
