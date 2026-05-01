//Copia de la entity
export interface Producto {
  id?: Number;  //Opcional ya que se generara en el backend
  nombre: String;
  precio: Number;
  stock: Number;
  codigoBarras: String;
  descripcion: String;
  precioVenta: Number;
  precioCosto: Number;
  fechaCreacion: Date;
  fechaActualizacion: Date;
}
