import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent {

  id:any;
  admin:any;
  constructor(private _route:ActivatedRoute,private _adminService:AdminService){
    _route.paramMap.subscribe(param=>{
      this.id= param.get('id')
    })
  }

  ngOnInit(){
    this._adminService.getById(this.id).subscribe(res=>{
      this.admin=res
    })
  
  }

}
