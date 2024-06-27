import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-adminorders',
  templateUrl: './adminorders.component.html',
  styleUrls: ['./adminorders.component.css']
})
export class AdminordersComponent {

  adminId:any;
  orders:any;
  err:any;
  constructor(private _adminService:AdminService,private _route:ActivatedRoute){
    this._route.paramMap.subscribe(param=>{
      this.adminId=param.get('id')
    })
  }

  ngOnInit(){
    this._adminService.getOrdersByAdminId(this.adminId).subscribe((res: any)=>{
      if(res){
        this.orders=res
      }else(
        this.err="no orders"
      )
    })
    
  }

  acceptOrder(orderId: number) {
    this._adminService.deliverOrder(orderId).subscribe(res => {
      Swal.fire('Delivered!', 'The order has been marked as delivered.', 'success');
      this.ngOnInit(); // Refresh the orders list
    }, err => {
      Swal.fire('Error!', 'There was an error updating the order status.', 'error');
    });
  }
}
