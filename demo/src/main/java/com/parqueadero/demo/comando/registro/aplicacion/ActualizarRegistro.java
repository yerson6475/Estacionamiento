package com.parqueadero.demo.comando.registro.aplicacion;

import com.parqueadero.demo.comando.registro.dominio.modelo.Registro;
import com.parqueadero.demo.comando.registro.dominio.servicio.ServicioRegistro;
import org.springframework.stereotype.Service;

@Service
public class ActualizarRegistro {

    private final ServicioRegistro servicioRegistro;

    public ActualizarRegistro(ServicioRegistro servicioRegistro) {
        this.servicioRegistro = servicioRegistro;
    }

    public Registro ejecutar(Long id) {
        return this.servicioRegistro.actualizar(id);
    }
}
