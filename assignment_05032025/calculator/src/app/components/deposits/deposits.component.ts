import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-deposits',
  imports: [CommonModule, FormsModule],
  templateUrl: './deposits.component.html',
  styleUrl: './deposits.component.css'
})
export class DepositsComponent {
  display: string = 'display: none;';
  maturityAmount: string = '';
  interestEarned: string = '';
  interestRate: number = 7;
  principalAmount: any;
  maturityPeriod: any;


  calculate() {
    const interestRate = this.interestRate / 100;
    const maturityAmount = this.principalAmount * Math.pow((1 + interestRate), this.maturityPeriod);
    const interestEarned = maturityAmount - this.principalAmount;
    this.maturityAmount = maturityAmount.toFixed(2);
    this.interestEarned = interestEarned.toFixed(2); 
    this.display = 'display: block;';
  }
}
