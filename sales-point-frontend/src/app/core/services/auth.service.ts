//Imports de angular
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';

//Imports de otros documentos
import { Usuario } from '../../shared/models/usuario.model';

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  private apiUrl = 'http://localhost:8080/api/auth';

  constructor(http: HttpClient) {   }

  crearUsuario(usuario: Usuario): Observable<Usuario>

}
