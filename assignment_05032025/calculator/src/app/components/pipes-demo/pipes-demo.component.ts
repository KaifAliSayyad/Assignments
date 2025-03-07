import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DiameterPipe } from '../../pipes/diameter.pipe';
import { AreaPipe } from '../../pipes/area.pipe';
import { PerimeterPipe } from '../../pipes/perimeter.pipe';
import { CurrencyPipe } from "../../pipes/currency.pipe";

@Component({
  selector: 'app-pipes-demo',
  imports: [CommonModule, FormsModule, AreaPipe, PerimeterPipe, DiameterPipe, CurrencyPipe],
  templateUrl: './pipes-demo.component.html',
  styleUrl: './pipes-demo.component.css'
})
export class PipesDemoComponent {
  radius: number = 0;
amountInINR: any;
}
