//Base
import { ApplicationConfig, provideBrowserGlobalErrorListeners } from '@angular/core';
import { provideRouter } from '@angular/router';

//Imports mios
import { authInterceptor } from './core/interceptors/auth.interceptor';

//Imports de rutas
import { routes } from './app.routes';
import {provideHttpClient, withInterceptors} from '@angular/common/http';

  export const appConfig: ApplicationConfig = {
    providers: [
      provideBrowserGlobalErrorListeners(),
      provideHttpClient(
        withInterceptors([authInterceptor])
      ),
      provideRouter(routes)
    ]
  };
