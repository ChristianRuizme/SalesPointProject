import { Component, OnInit } from '@angular/core';
import { ProductoService} from '../../../core/services/producto.service';
import { Producto} from '../../../Shared/models/producto.model';

//Metadata
@Component({
  selector: 'app-lista-productos',
  templateUrl: './lista-productos.html',
  styleUrl: './lista-productos.scss',
  standalone: true
})

//Clase
export class ListaProductosComponent implements OnInit {
  //Variable para guardar lo que llegue del backend
  public productos: Producto[] = [];

  //Inyectamos el ProductoService
  constructor(private productoService: ProductoService) {   }

  //Funciona como un useEffect de React
  ngOnInit(): void {
    this.cargarProductos();
  }

  //Metodo para pasar productos del backend y mandarlos a frontend
  cargarProductos(): void {
    //.subscribe es el escuchador
    this.productoService.obtenerProductos().subscribe({
      next: (data) => { //Exito
        this.productos = data;
        console.log("Productos cargados: ", this.productos);
      },
      error: (err) => { //Fracaso
        console.error("Ocurrio un error al conectar al backend: ", err);
      }
    });
  }

}
