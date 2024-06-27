import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private _url = 'http://localhost:8080/api/admin/';

  constructor(private _http: HttpClient) { }

  getById(id: any): Observable<any> {
    return this._http.get(this._url + id);
  }

  addProduct(adminId: any, product: any): Observable<any> {
    return this._http.post<any>(`${this._url}addproduct/${adminId}`, product);
  }

  updateProduct(adminId: any, productId: any, product: any): Observable<any> {
    return this._http.put<any>(`${this._url}product/${productId}`, product);
  }

  deleteProduct(productId: any): Observable<any> {
    return this._http.delete<any>(`${this._url}product/${productId}`);
  }

  productsById(id: any): Observable<any> {
    return this._http.get(`${this._url}products/` + id);
  }

  getOrdersByAdminId(adminId: any): Observable<any> {
    return this._http.get(`http://localhost:8080/userorders/orders/` + adminId);
  }

  getProductById(productId: any): Observable<any> {
    return this._http.get(`${this._url}product/${productId}`);
  }

  deliverOrder(orderId: number): Observable<any> {
    return this._http.patch(`${this._url}order/${orderId}/deliver`, {});
  }
}
