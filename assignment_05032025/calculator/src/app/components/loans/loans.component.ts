import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';


interface Loan {
  type: string;
  interestRate: number;
  minAmount: number;
  maxAmount: number;
  tenure: number;
}

@Component({
  selector: 'app-loans',
  imports: [CommonModule, FormsModule],
  templateUrl: './loans.component.html',
  styleUrl: './loans.component.css'
})

export class LoansComponent {
  name: string = '';
  loans: Loan[] = [
    { type: 'Car Loan', interestRate: 11, minAmount: 100000, maxAmount: 1500000, tenure: 7 },
    { type: 'Home Loan', interestRate: 9, minAmount: 500000, maxAmount: 10000000, tenure: 30 },
    { type: 'Personal Loan', interestRate: 15, minAmount: 10000, maxAmount: 500000, tenure: 5 }
  ]

  selectedLoanType: Loan = this.loans[0];
  display: string = "display : none";
  exactTenure: number = 0;
  exactAmount: number = 0;
  monthlyEmi: string = '';
  totalInterest: string = '';
  totalAmount: string = '';



  selectLoan(loan: Loan): void {
    this.selectedLoanType = loan;
    console.log(this.selectedLoanType);
  }

  calculate(): void {
    let { interestRate, minAmount, maxAmount, tenure } = this.selectedLoanType;
    if(this.name.length == 0){
      console.log("Please enter name..🙏");
      return;
    }
    if (this.exactAmount < minAmount || this.exactAmount > maxAmount) {
      console.log(this.exactAmount);
      console.log("Please enter amount in given range only..🙏");
      return;
    }
    if (this.exactTenure > tenure) {
      console.log(this.exactTenure);
      console.log("Please enter tenure in given range only..🙏");
      return;
    }
    interestRate = interestRate / 100;

    // Convert annual interest rate to monthly and tenure to months
    const monthlyRate = interestRate / 12;
    const tenureMonths = tenure * 12;

    // Calculate EMI: [P x R x (1+R)^N]/[(1+R)^N-1]
    const emi = (this.exactAmount * monthlyRate * Math.pow(1 + monthlyRate, tenureMonths)) /
      (Math.pow(1 + monthlyRate, tenureMonths) - 1);
      const tA = emi * tenureMonths;
      const tI = tA - this.exactAmount;
      this.monthlyEmi = emi.toFixed(2);
      this.totalAmount = tA.toFixed(2);
      this.totalInterest = tI.toFixed(2);

    this.display = "display : block";
  }

}
