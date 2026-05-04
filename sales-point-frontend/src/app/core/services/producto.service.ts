//Imports de Angular
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

//Imports de otros documentos
import { Producto } from '../../shared/models/producto.model';

//Se crea una instancia de esta clase al arrancar y se va al root para usarse facilmente
@Injectable({
  providedIn: 'root'
})

export class ProductoService {
  private apiUrl = 'http://localhost:8080/api/productos';

  constructor(private http: HttpClient) {  }

  obtenerProductos(): Observable<Producto[]> {
    return this.http.get<Producto[]>(this.apiUrl);
  }

  crearProducto(producto: Producto): Observable<Producto> {
    return this.http.post<Producto>(this.apiUrl, producto);
  }
}
