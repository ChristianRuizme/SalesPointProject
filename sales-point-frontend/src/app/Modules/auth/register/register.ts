import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {ReactiveFormsModule, FormGroup, FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-register',
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './register.html',
  styleUrl: './register.scss',
  standalone: true
})
export class RegisterComponent {

  //Configuracion del formulario
  protected registerForm = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.minLength(3)]),
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)]),
    role: new FormControl('CAJERO', [Validators.required])
  })

  constructor(private router: Router)  {   }

  onRegister() {
    if (this.registerForm.valid) {
      console.log("Datos del formulario para backend: ", this.registerForm.value);
      this.router.navigate(['/inventario']);
    } else {
      console.log("Formulario no valido");
    }
  }
}
