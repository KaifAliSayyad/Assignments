import { Injectable } from '@angular/core';
import { Customer } from '../interfaces/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  public customers: Customer[] = [];

  constructor() { }

  addCustomer(customer: Customer) {
    this.customers.push(customer);
    
  }
}
