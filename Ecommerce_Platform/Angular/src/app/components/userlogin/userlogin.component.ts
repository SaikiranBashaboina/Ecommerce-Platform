import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent {
  email:any="@gmail.com";
  password: any="";
  constructor(private authService: AuthService, private router: Router) { }

  login() {
    this.authService.userLogin(this.email, this.password).subscribe((res) => {
      if(res){
        this.router.navigate(['/userhome/'+res]);
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
