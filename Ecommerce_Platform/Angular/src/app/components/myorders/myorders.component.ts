import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-myorders',
  templateUrl: './myorders.component.html',
  styleUrls: ['./myorders.component.css']
})
export class MyordersComponent {
  id:any;

  orders:any;
err:any;
  constructor(private _route:ActivatedRoute,private _userService:UserService ){
    _route.paramMap.subscribe(param=>{
      this.id= param.get('id')
    })
  }

  ngOnInit(){
    this._userService.getOrdersByUserId(this.id).subscribe((res: any)=>{
      if(res){
        this.orders=res
      }else(
        this.err="no orders"
      )
    })
}

cancelOrder(orderId: number) {
  this._userService.cancelOrder(orderId).subscribe(res => {
    Swal.fire('Cancelled!', 'Your order has been cancelled.', 'success');
    this.ngOnInit(); // Refresh the orders list
  }, err => {
    Swal.fire('Error!', 'There was an error cancelling your order.', 'error');
  });
}
}
