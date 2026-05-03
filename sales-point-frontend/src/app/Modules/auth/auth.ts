import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-auth',
  imports: [
    RouterOutlet,
    RouterLink
  ],
  templateUrl: './auth.html',
  styleUrl: './auth.scss',
  standalone: true
})
export class AuthComponent {

}
