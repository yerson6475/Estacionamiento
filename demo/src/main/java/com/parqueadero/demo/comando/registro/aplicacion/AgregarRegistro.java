package com.parqueadero.demo.comando.registro.aplicacion;

import com.parqueadero.demo.comando.registro.dominio.modelo.Registro;
import com.parqueadero.demo.comando.registro.dominio.servicio.ServicioRegistro;
import org.springframework.stereotype.Service;

@Service
public class AgregarRegistro {

    private ServicioRegistro servicioRegistro;

    public AgregarRegistro(ServicioRegistro servicioRegistro) {
        this.servicioRegistro = servicioRegistro;
    }

    public Registro ejecutar(Registro registro) {
       return this.servicioRegistro.crear(registro);
    }


}
