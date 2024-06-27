import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent {
  email:any="@gmail.com";
  password: any="";

  constructor(private authService: AuthService, private router: Router) { }

  login() {
    this.authService.adminLogin(this.email, this.password).subscribe((res) => {
      if(res){
        this.router.navigate(['/adminhome/'+res]);
      }
      
    }, error => {
      console.error('Login error', error);
      Swal.fire({
        icon: 'error',
        title: 'Login Failed',
        text: 'Incorrect email or password',
      });
    })
  }

}
