import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-userhome',
  templateUrl: './userhome.component.html',
  styleUrls: ['./userhome.component.css']
})
export class UserhomeComponent {

  id:any;
  user:any;
  constructor(private _route:ActivatedRoute,private _userService:UserService){
    _route.paramMap.subscribe(param=>{
      this.id= param.get('id')
    })
  }

  ngOnInit(){
    this._userService.getById(this.id).subscribe(res=>{
      this.user=res
    })
  
  }

}
