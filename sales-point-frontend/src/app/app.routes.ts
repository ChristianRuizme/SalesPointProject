import { Routes } from '@angular/router';
import { AuthComponent} from './modules/auth/auth';
import { LoginComponent} from './modules/auth/login/login';

//Las rutas que puede seguir la pagina
export const routes: Routes = [
  { path: 'auth',
    children: [
      { path: 'login', component: LoginComponent },
    ]
  },
  { path: '', redirectTo: 'auth/login', pathMatch: 'full' },
  { path: '**', redirectTo: 'auth/login' }
];
