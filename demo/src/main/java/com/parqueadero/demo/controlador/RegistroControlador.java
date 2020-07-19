package com.parqueadero.demo.controlador;


import com.parqueadero.demo.modelo.Registro;
import com.parqueadero.demo.servicio.RegistroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class RegistroControlador {

    @Autowired
    RegistroServicio registroServicio;

    @RequestMapping(value = "/registro", method = RequestMethod.POST)
    Registro crear(@RequestBody Registro registro) {
       return this.registroServicio.crear(registro);
    }

    @RequestMapping(value ="/registro/{id}", method = RequestMethod.PUT )
    Registro actualizar(@PathVariable Long id) {
        return this.registroServicio.actualizar(id);
    }

    @RequestMapping(value="/registro", method = RequestMethod.GET)
    List<Registro> listarVehiculos () {
        return this.registroServicio.listarVehiculos();
    }

    @RequestMapping(value = "/registro/{placa}", method = RequestMethod.GET)
    List<Registro> listarPorPlaca (@PathVariable String placa ) {
        return this.registroServicio.listarPorPlaca(placa);
    }

    @RequestMapping(value = "/registro/{id}", method = RequestMethod.DELETE)
    void eliminar (@PathVariable Long id) {
        this.registroServicio.eliminar(id);
    }
}
