package com.parqueadero.demo.servicio;

import com.parqueadero.demo.modelo.Registro;
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

    public Registro crear(Registro registro) {
        registro.setFechaIngreso(LocalDateTime.now());
        return registroRepositorio.save(registro);
    }

    public Registro actualizar(Long id) {
        Optional<Registro> registroOptional = this.registroRepositorio.findById(id);

        Registro registro = registroOptional.get();
        registro.setFechaSalida(LocalDateTime.now());
        registro.setTotalPago(obtenerTotalPagar(registro));
        return this.registroRepositorio.save(registro);

    }

    private BigDecimal obtenerTotalPagar(Registro registro) {

        BigDecimal totalPagar = BigDecimal.ZERO;
        Duration duracion = Duration.between(registro.getFechaIngreso(), registro.getFechaSalida());
        Long minutosParqueo = duracion.toMinutes();

        switch (registro.getTipo()) {

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

    public List<Registro> listarVehiculos() {
        return  this.registroRepositorio.findByFechaSalidaIsNull();
    }

    public List<Registro> listarPorPlaca(String placa) {
        return this.registroRepositorio.findByPlaca(placa);
    }

    public void  eliminar(Long id) {
         this.registroRepositorio.deleteById(id);
    }
}
