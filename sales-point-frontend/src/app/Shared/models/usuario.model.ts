//Imports de otros archivos
import { Role } from './role.enum';

export interface Usuario {
  name: String;
  email: String;
  password: String;
  role: Role;
}
