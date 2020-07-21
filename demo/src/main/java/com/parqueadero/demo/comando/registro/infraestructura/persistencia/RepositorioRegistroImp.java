package com.parqueadero.demo.comando.registro.infraestructura.persistencia;

import com.parqueadero.demo.comando.registro.dominio.modelo.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioRegistroImp extends JpaRepository<Registro, Long> {
}
