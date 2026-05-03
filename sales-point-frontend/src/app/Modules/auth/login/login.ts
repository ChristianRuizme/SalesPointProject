import { Component, OnInit } from '@angular/core';
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

  //Configuracion del formulario
  protected loginForm = new FormGroup({
    user: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)])
  })

  constructor(private router: Router)  {   }

  ngOnInit() {
    //Aqui puedo checar si ya tiene sesion anterior
  }

  onLogin() {
    if (this.loginForm.valid) {
      console.log("Datos del formulario: ", this.loginForm.value);
      this.router.navigate(['/inventario']);
    } else {
      console.log("Formulario no valido");
    }
  }
}
