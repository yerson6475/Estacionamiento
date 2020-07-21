package com.parqueadero.demo.consulta.registro.infraestructura.controlador;

import com.parqueadero.demo.consulta.registro.aplicacion.ListarRegistros;
import com.parqueadero.demo.consulta.registro.dominio.modelo.DtoRegistro;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ConsultaRegistro {

    private final ListarRegistros listarRegistros;

    public ConsultaRegistro(ListarRegistros listarRegistros) {
        this.listarRegistros = listarRegistros;
    }

    @RequestMapping(value = "/registro", method = RequestMethod.GET)
    public DtoRegistro listar() {
        return this.listarRegistros.ejecutar();
    }
}
