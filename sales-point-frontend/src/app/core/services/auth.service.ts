//Imports de angular
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

//Imports de otros documentos
import { Usuario } from '../../shared/models/usuario.model';
import { UsuarioLogin } from '../../shared/models/usuario-login.model';

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  private apiUrl = 'http://localhost:8080/api/auth';

  constructor(private http: HttpClient) {   }

  crearUsuario(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(`${this.apiUrl}/register`, usuario);
  }

  identificarUsuario(usuario: UsuarioLogin): Observable<UsuarioLogin> {
    return this.http.post<any>(`${this.apiUrl}/login`, usuario)
  }

}
