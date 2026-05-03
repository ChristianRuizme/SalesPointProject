import { Routes } from '@angular/router';
import { AuthComponent} from './modules/auth/auth';
import { WelcomeComponent } from './modules/auth/welcome/welcome';
import { LoginComponent} from './modules/auth/login/login';
import { RegisterComponent } from './modules/auth/register/register';

//Las rutas que puede seguir la pagina
export const routes: Routes = [
  { path: 'auth', component: AuthComponent,
    children: [
      { path: 'welcome', component: WelcomeComponent },
      { path: 'login', component: LoginComponent },
      { path: 'register', component: RegisterComponent },
      //Por si entran a auth a secas, manda welcome
      { path: '', redirectTo: 'welcome', pathMatch: 'full' }
    ]
  },
  { path: '', redirectTo: '/auth/welcome', pathMatch: 'full' },
  { path: '**', redirectTo: '/auth/welcome' }
];
