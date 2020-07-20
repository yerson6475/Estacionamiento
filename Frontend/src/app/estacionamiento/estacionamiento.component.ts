import { Component, OnInit } from '@angular/core';
import { RegistroService } from '../service/registro.service';
import { Registro } from './modelo/regsitro';

@Component({
  selector: 'app-estacionamiento',
  templateUrl: './estacionamiento.component.html',
  styleUrls: ['./estacionamiento.component.css']
})
export class EstacionamientoComponent implements OnInit {
  registro: Registro = new Registro();
  listarRegistros: Registro[];
  registrosPorPlaca: Registro[];

  constructor(private registroService: RegistroService) { }

  ngOnInit(): void {
  }

  crearRegistro() {
    this.registroService.crear(this.registro).subscribe(
      data => {
        this.listarVehiculos();
      }
    );
  }

  pagoSalida(id: number) {
    this.registroService.actualizar(id).subscribe(
      res => {
        this.registro = res;
        this.listarVehiculos();
      }
    );
  }

  listarVehiculos() {
    this.registroService.listar().subscribe(
      data => {
        this.listarRegistros = data;
      }
    );
  }

  listarPorPlaca(placa: string) {
    this.registroService.listarPorPlaca(placa).subscribe(
      data => {
       this.registrosPorPlaca = data;
      }
    );
  }

}
