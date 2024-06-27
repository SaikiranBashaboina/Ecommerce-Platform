import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private _url="http://localhost:8080/users/"

  constructor(private _http:HttpClient) { }

  getById(id:any):Observable<any>{
    return this._http.get(this._url+id)
  }

  allproducts(id:any):Observable<any>{
    return this._http.get(`${this._url}allproducts/`+id)
  }

  orderProduct(userId: any, product: any): Observable<any> {
    return this._http.post(`${this._url}order/`+userId, product);
  }

  getOrdersByUserId(adminId: any): Observable<any> {
    return this._http.get(`http://localhost:8080/userorders/myorders/` + adminId);
  }

  cancelOrder(orderId: number): Observable<any> {
    return this._http.patch(`${this._url}order/${orderId}/cancel`, {});
  }
  
}
