import { Component } from '@angular/core';
//Imports de otros componentes
import { ListaProductosComponent } from './lista-productos/lista-productos';

@Component({
  selector: 'app-inventario',
  imports: [
    ListaProductosComponent
  ],
  templateUrl: './inventario.html',
  styleUrl: './inventario.scss',
  standalone: true
})
export class Inventario {}
