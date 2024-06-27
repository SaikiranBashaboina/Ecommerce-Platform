import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-addproducts',
  templateUrl: './addproducts.component.html',
  styleUrls: ['./addproducts.component.css']
})
export class AddProductComponent implements OnInit {
  product: any = {};
  id: any;
  productId: any;
  isEdit: boolean = false;

  constructor(private _route: ActivatedRoute, private adminService: AdminService,private _rot:Router) {
    _route.paramMap.subscribe(param => {
      this.id = param.get('id');
      this.productId = param.get('productId');
    });
  }

  ngOnInit() {
    if (this.productId) {
      this.isEdit = true;
      this.adminService.getProductById(this.productId).subscribe(
        product => {
          this.product = product;
        },
        error => {
          console.error('Error fetching product details', error);
        }
      );
    }
  }

  onSubmit() {
    if (this.isEdit) {
      this.adminService.updateProduct(this.id, this.productId, this.product).subscribe(
        response => {
          Swal.fire('Updated!', 'Product updated successfully.', 'success');
          this._rot.navigate(['/adminproducts/'+this.id])
        },
        error => {
          console.error('Error updating product', error);
        }
      );
    } else {
      this.adminService.addProduct(this.id, this.product).subscribe(
        response => {
          Swal.fire('Added!', 'Product added successfully.', 'success');
          this._rot.navigate(['/adminproducts/'+this.id])
        },
        error => {
          console.error('Error adding product', error);
        }
      );
    }
  }
}
