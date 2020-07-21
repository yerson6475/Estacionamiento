package com.parqueadero.demo.comando.registro.infraestructura.controlador;

import com.parqueadero.demo.comando.registro.aplicacion.ActualizarRegistro;
import com.parqueadero.demo.comando.registro.aplicacion.AgregarRegistro;
import com.parqueadero.demo.comando.registro.dominio.modelo.Registro;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class ControladorRegistro {

    private final AgregarRegistro agregarRegistro;
    private final ActualizarRegistro actualizarRegistro;

    ControladorRegistro(AgregarRegistro agregarRegistro, ActualizarRegistro actualizarRegistro) {
        this.agregarRegistro = agregarRegistro;
        this.actualizarRegistro = actualizarRegistro;
    }

    @RequestMapping(value = "/registro", method = RequestMethod.POST)
    Registro ingresar(@RequestBody Registro registro) {
        return this.agregarRegistro.ejecutar(registro);
    }

    @RequestMapping(value = "/registro/{id}", method = RequestMethod.PUT)
    Registro actualizar(@PathVariable Long id) {
        return this.actualizarRegistro.ejecutar(id);
    }

    @RequestMapping(value = "/registro/{id}", method = RequestMethod.DELETE)
    void eliminar(@PathVariable long id) {

    }
}
