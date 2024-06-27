import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  private loggedInAdminId:any;

  //adminlogin
  adminLogin(email: string, password: string): Observable<any> {
    return this.http.post<any>('http://localhost:8080/api/admin/login', { email, password });
    
  }

  //adminregisetr
  adminRegister(adminData: any): Observable<any> {
    return this.http.post<any>('http://localhost:8080/api/admin/register', adminData);
  }
//userlogin
  userLogin(email: string, password: string): Observable<any> {
    return this.http.post<any>('http://localhost:8080/users/login', { email, password });
  }
//userregister
  userRegister(userData: any): Observable<any> {
    return this.http.post<any>('http://localhost:8080/users/register', userData);
  }

}
