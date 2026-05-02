import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [],
  templateUrl: './login.html',
  styleUrl: './login.scss',
  standalone: true
})
export class LoginComponent implements OnInit {

  constructor(private router: Router)  {   }

  ngOnInit() {
    //Aqui puedo checar si ya tiene sesion anterior
  }

  onLogin() {
    console.log("Iniciando sesion");
    this.router.navigate(['/inventario']);
  }
}
