import { Component } from '@angular/core';
import { DepositsComponent } from "../deposits/deposits.component";
import { LoansComponent } from "../loans/loans.component";
import { SIPComponent } from "../sip/sip.component";
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { PipesDemoComponent } from "../pipes-demo/pipes-demo.component";

@Component({
  selector: 'app-main',
  imports: [DepositsComponent, LoansComponent, SIPComponent, CommonModule, PipesDemoComponent],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent {
  calc: string = 'loans';
  
  setDeposit(): void {
    this.calc = 'deposits';
  }
  
  setLoan(): void {
    this.calc = 'loans';
    
  }
  
  setSip() {
    this.calc = 'sips';
  }

  setPipe(){
    this.calc = 'pipes';
  }
}
