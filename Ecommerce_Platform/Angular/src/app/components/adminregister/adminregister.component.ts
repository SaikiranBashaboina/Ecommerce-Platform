import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-adminregister',
  templateUrl: './adminregister.component.html',
  styleUrls: ['./adminregister.component.css']
})
export class AdminregisterComponent {


  constructor(private  authservice:AuthService,private snack:MatSnackBar,private _router:Router){}

  public user={
    firstname:'',
    lastname:'',
    email:'@gmail.com',
    password:'',
    phone:'',

  }

  formsubmit(){
    console.log(this.user)
   if(this.user.firstname=='' || this.user.lastname==null){
    //alert('User is Required !!');
    this.snack.open("Fill All The Required fields!!",'ok');
    return;
   }
   this.authservice.adminRegister(this.user).subscribe(
    (data:any)=>{
      // console.log(this.user.email);
      // alert('success');
      Swal.fire({
        title: "Registred!",
        text: "Registered Successfully!",
        icon: "success"
      });
      this._router.navigateByUrl("/home")

    }
   );

  }
}
