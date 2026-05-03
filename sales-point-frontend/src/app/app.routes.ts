import { Routes } from '@angular/router';
import { AuthComponent} from './modules/auth/auth';
import { LoginComponent} from './modules/auth/login/login';
import {RegisterComponent} from './modules/auth/register/register';

//Las rutas que puede seguir la pagina
export const routes: Routes = [
  { path: 'auth',
    children: [
      { path: 'login', component: LoginComponent },
      {path: 'register', component: RegisterComponent }
    ]
  },
  { path: '', redirectTo: 'auth', pathMatch: 'full' },
  { path: '**', redirectTo: 'auth' }
];
