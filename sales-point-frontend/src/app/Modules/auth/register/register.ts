//Imports de otros archivos
import { Usuario } from '../../../shared/models/usuario.model';
import { Role } from '../../../shared/models/role.enum';

//Imports de Angular
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormGroup, FormControl, Validators } from '@angular/forms';
import {AuthService} from '../../../core/services/auth.service';

@Component({
  selector: 'app-register',
  imports: [
    ReactiveFormsModule,
    CommonModule
  ],
  templateUrl: './register.html',
  styleUrl: './register.scss',
  standalone: true
})
export class RegisterComponent {

  //Configuracion del formulario, esto va primero
  protected registerForm = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.minLength(3)]),
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)]),
    role: new FormControl('', [Validators.required])
  })

  public hidePassword = true;

  //Luego las inyecciones
  constructor(
    private router: Router,
    private authService: AuthService
  )  { }

    //Al final los metodos
    onRegister() {
      console.log("Click detectado");
      if (this.registerForm.valid) {
        console.log("Datos del formulario para backend: ", this.registerForm.value);
        this.authService.crearUsuario(this.registerForm.value as Usuario).subscribe({
          next: (res) => {
            console.log("Registrado en la DB");
            this.router.navigate(['/inventario']);
          },
          error: (err) => {
            console.log("Error al registrar: ", err);
          }
        });
      }
    }
}
