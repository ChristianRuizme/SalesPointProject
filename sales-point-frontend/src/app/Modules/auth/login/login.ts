//Imports de documentos
import { AuthService } from '../../../core/services/auth.service';
import { UsuarioLogin } from '../../../shared/models/usuario-login.model';

//Imports de librerias
import {Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import {ReactiveFormsModule, FormGroup, FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './login.html',
  styleUrl: './login.scss',
  standalone: true
})

export class LoginComponent implements OnInit {

  //Variables
  errorEmail: String = "";
  errorPassword: String = "";

  //Configuracion del formulario
  protected loginForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)])
  })

  constructor(
    private router: Router,
    private authService : AuthService
  )  {   }

  ngOnInit() {
    //Aqui puedo checar si ya tiene sesion anterior
  }

  onLogin() {
    if (this.loginForm.valid) {
      console.log("Datos del formulario: ", this.loginForm.value);
      this.authService.identificarUsuario(this.loginForm.value as UsuarioLogin).subscribe({
        next: (res) => {
          console.log("Iniciando sesion");
          this.router.navigate(['/inventario']);
        },
        error: (err) => {
          console.log("Ocurrio un error al iniciar sesion");
          if (err.status === 404) {
            this.errorEmail = err.error.mensaje;
          } else if (err.status === 401) {
            this.errorPassword = err.error.mensaje;
          }
        }
      })
    } else {
      console.log("Formulario no valido");
    }
  }
}
