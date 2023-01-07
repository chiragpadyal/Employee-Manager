import { Component, OnInit } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';
import { ApiserviceService } from './apiservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'internAngular';
  constructor(private auth: AuthService, private service: ApiserviceService) {}

  ngOnInit(): void {
    this.auth.isAuthenticated$.subscribe((data) => {
      this.auth.getAccessTokenSilently().subscribe((data) => {
        console.log(data);
        // this.scannService.loginUser = this.service.parseJwt(data).sub.replace('|', '%7C');
      });
    });
  }
}
