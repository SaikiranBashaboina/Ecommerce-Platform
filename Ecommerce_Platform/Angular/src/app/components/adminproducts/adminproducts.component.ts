import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-adminproducts',
  templateUrl: './adminproducts.component.html',
  styleUrls: ['./adminproducts.component.css']
})
export class AdminproductsComponent {
  msg: any;
  products: any;
  id: any;

  constructor(private _route: ActivatedRoute, private _adminService: AdminService, private _router: Router) {
    _route.paramMap.subscribe(param => {
      this.id = param.get('id');
    });

    this.loadProducts();
  }

  loadProducts() {
    this._adminService.productsById(this.id).subscribe(res => {
      if (res) {
        this.products = res;
      } else {
        this.msg = "no products";
      }
    });
  }

  onEdit(productId: any) {
    this._router.navigate(['/addproducts', this.id, productId]);
  }

  onDelete(productId: any) {
    this._adminService.deleteProduct(productId).subscribe(
      response => {
        Swal.fire('Deleted!', 'Product has been deleted.', 'success');
        this.loadProducts(); // Refresh the product list
      },
      error => {
        Swal.fire('Error!', 'Error deleting product.', 'error');
        console.error('Error deleting product', error);
      }
    );
  }
}
