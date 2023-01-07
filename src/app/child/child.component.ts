import { Component, Output, EventEmitter } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css'],
})
export class ChildComponent {
  @Output() clicked = new EventEmitter<boolean>();

  constructor(public auth: AuthService) {}

  addEmployeeClicked() {
    this.clicked.emit(true);
  }
}
