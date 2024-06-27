import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2'; // Import SweetAlert2

@Component({
  selector: 'app-allproducts',
  templateUrl: './allproducts.component.html',
  styleUrls: ['./allproducts.component.css']
})
export class AllproductsComponent implements OnInit {
  id: any;
  user: any;
  products: any[] = [];

  constructor(private _route: ActivatedRoute, private _userService: UserService) {
    _route.paramMap.subscribe(param => {
      this.id = param.get('id');
    });
  }

  ngOnInit() {
    this._userService.allproducts(this.id).subscribe(res => {
      this.products = res;
      console.log(res);
    });

    this._userService.getById(this.id).subscribe(res => {
      this.user = res;
    });
  }

  orderProduct(product: any) {
    const order = {
      name: product.name,
      price: product.price,
      description: product.description,
      imageUrl: product.imageUrl,
      product: { productId: product.productId },
      admin: { adminId: product.admin.adminId }  // Include adminId
    };

    this._userService.orderProduct(this.id, order).subscribe(res => {
      console.log('Order placed successfully', res);
      Swal.fire('Order Placed!', 'Your order has been placed successfully.', 'success');

    }, err => {
      console.log('Error placing order', err);
      Swal.fire('Order Failed!', 'There was an error placing your order. Please try again.', 'error');

    });
  }
}
