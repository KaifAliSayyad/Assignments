import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { Customer } from '../../interfaces/customer';
import { AbstractControl, FormControl, FormGroup, ReactiveFormsModule, ValidationErrors } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-register',
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  constructor(private cs: CustomerService) { }
  password_out: string = "";

  customerForm: any;

  ngOnInit(): void {
    this.customerForm = new FormGroup({
      id: new FormControl(null, { validators: this.idValidator }),
      username: new FormControl(null, {validators: this.usernameValidator}),
      password: new FormControl(null, {validators: this.passwordValidator}),
      confirmPassword: new FormControl(null, {validators: this.confirmPasswordValidator}),
      accountNo: new FormControl(null, {validators: this.accountNoValidator})

    });
  }

  idValidator(control: AbstractControl): ValidationErrors | null {
    if (!control.value) return { id: 'ID is required' };
    const regex = /^[0-9]{7}$/;
    return regex.test(control.value) ? null : { id: 'ID must be exactly 7 digits' };
  }

  usernameValidator(control: AbstractControl): ValidationErrors | null {
    if (!control.value) return { username: 'Username is required' };
    const regex = /^\w{5,}$/;
    return regex.test(control.value) ? null : { username: 'Username must be at least 5 characters' };
  }

  passwordValidator(control: AbstractControl): ValidationErrors | null {
    if (!control.value) return { password: 'Password is required' };

    const hasNumber = /\d/.test(control.value);
    const hasLetter = /[a-zA-Z]/.test(control.value);
    const hasSpecialChar = /[!@#$%^&*]/.test(control.value);
    const isValidLength = control.value.length >= 5;

    if (hasNumber && hasLetter && hasSpecialChar && isValidLength) {
      this.password_out = control.value;
      return null;
    }

    return { password: 'Password must have at least 5 characters, include a letter, a number, and a special character' };
  }

  confirmPasswordValidator(control: AbstractControl): ValidationErrors | null {
    if (!control.value) return { confirmPassword: 'Confirm Password is required' };
    return control.value === this.password_out ? null : { confirmPassword: 'Passwords do not match' };
  }

  accountNoValidator(control: AbstractControl): ValidationErrors | null {
    if (!control.value) return { accountNo: 'Account Number is required' };
    const regex = /^[0-9]{6,}$/;
    return regex.test(control.value) ? null : { accountNo: 'Account Number must be at least 6 digits' };
  }

  submitForm(obj: any): void {
    const customer: Customer = {
      id: obj.id,
      username: obj.username,
      password: obj.password,
      accountNo: obj.accountNo
    }
    this.cs.addCustomer(customer);
    console.log(customer);
  }
}
