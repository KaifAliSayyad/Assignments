import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { RegisterComponent } from "./components/register/register.component";
import { LoginComponent } from "./components/login/login.component";

@Component({
  selector: 'app-root',
  imports: [RegisterComponent, LoginComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
registerStyle: string = "background-color: cadetblue";
loginStyle: string = "background-color: white";


  setRegister() {
    this.isRegister = true;
    this.loginStyle = "background-color: white";
    this.registerStyle = "background-color: cadetblue";
    
  }
  setLogin() {
    this.isRegister = false;
    this.registerStyle = "background-color: white";
    this.loginStyle = "background-color: cadetblue";
  }
  title = 'customer-form';
  isRegister: boolean = true;
}
