import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-sip',
  imports: [CommonModule, FormsModule],
  templateUrl: './sip.component.html',
  styleUrl: './sip.component.css'
})
export class SIPComponent {
  display: string = 'display: none;';
  roi: number = 0;
  duration: number = 0;
  amount: number = 0;
  returns: string = '';
  calculate() {
    if (this.roi < -25 || this.roi > 25) {
      console.log(this.roi);
      console.log('Please select ROI in range of (-25 - 25%)');
      return;
    }
    const monthlyRate = this.roi / (100 * 12); // Convert annual ROI (%) to monthly decimal rate
    this.returns = (this.amount * (((Math.pow(1 + monthlyRate, this.duration) - 1) / monthlyRate) * (1 + monthlyRate))).toFixed(2);
    this.display = 'display: block;';
  }

}
