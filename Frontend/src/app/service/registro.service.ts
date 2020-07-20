import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Registro } from '../estacionamiento/modelo/regsitro';

@Injectable({
  providedIn: 'root'
})
export class RegistroService {

  constructor(private http: HttpClient) { }

  crear(registro: Registro): Observable<Registro> {
    return this.http.post<Registro>('http://localhost:8080/registro', registro);
  }

  actualizar(id: number): Observable<Registro> {
    return this.http.put<Registro>('http://localhost:8080/registro/' + id, null);
  }

  listar(): Observable<Registro[]> {
    return this.http.get<Registro[]>('http://localhost:8080/registro');
  }

  listarPorPlaca(placa: string ): Observable<Registro[]> {
    return this.http.get<Registro[]>('http://localhost:8080/registro/' + placa);
  }

}
