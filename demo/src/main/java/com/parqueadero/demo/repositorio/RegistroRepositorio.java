package com.parqueadero.demo.repositorio;

import com.parqueadero.demo.modelo.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroRepositorio extends JpaRepository<Registro, Long> {

    List<Registro> findByFechaSalidaIsNull();

    List<Registro> findByPlaca(String placa);
}
