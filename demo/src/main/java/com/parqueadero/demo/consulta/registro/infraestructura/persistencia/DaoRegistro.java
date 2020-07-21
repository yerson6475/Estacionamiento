package com.parqueadero.demo.consulta.registro.infraestructura.persistencia;

import com.parqueadero.demo.consulta.registro.dominio.modelo.DtoRegistro;
import com.parqueadero.demo.modelo.Registrouno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DaoRegistro extends JpaRepository<DtoRegistro, Long> {

    List<Registrouno> findByPlaca(String placa);
}
