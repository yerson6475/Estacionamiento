package com.parqueadero.demo.comando.registro.dominio.servicio;

import com.parqueadero.demo.comando.registro.dominio.modelo.Registro;
import com.parqueadero.demo.comando.registro.infraestructura.persistencia.RepositorioRegistroImp;
import com.parqueadero.demo.modelo.Registrouno;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ServicioRegistro {

    private final RepositorioRegistroImp repositorioRegistroImp;

    public ServicioRegistro(RepositorioRegistroImp repositorioRegistroImp ) {
        this.repositorioRegistroImp = repositorioRegistroImp;
    }

    public Registro crear(Registro registro) {

        registro.setFechaIngreso(LocalDateTime.now());
        return this.repositorioRegistroImp.save(registro);
    }

    public Registro actualizar(Long id) {

        Optional<Registro> registroOptional = this.repositorioRegistroImp.findById(id);

        Registro registro = registroOptional.get();
        registro.setFechaSalida(LocalDateTime.now());
        registro.setTotalPago(CalcularPago(registro));
        return this.repositorioRegistroImp.save(registro);
    }

    private BigDecimal CalcularPago(Registro registro) {
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
}
