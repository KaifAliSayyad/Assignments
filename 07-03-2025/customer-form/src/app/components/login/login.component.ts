import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';

import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [RouterOutlet, CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  isVerified: boolean = false;
  constructor(public cs: CustomerService) {

  }

  login(customerId: string, password: string) {
    const customer = this.cs.customers.find(c => c.id === customerId && c.password === password);
    if (customer) {
      this.isVerified = true;   //show <app-welcome>
    } else {
      // Handle invalid login
      console.log('Invalid customer ID or password');
    }
  }

}
