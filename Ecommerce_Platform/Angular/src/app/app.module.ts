import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomepageComponent } from './components/homepage/homepage.component';
import { UserhomeComponent } from './components/userhome/userhome.component';
import { AdminhomeComponent } from './components/adminhome/adminhome.component';
import { AdminloginComponent } from './components/adminlogin/adminlogin.component';
import { UserloginComponent } from './components/userlogin/userlogin.component';
import { UserregisterComponent } from './components/userregister/userregister.component';
import { AdminregisterComponent } from './components/adminregister/adminregister.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import {MatCardModule} from '@angular/material/card';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import { AddProductComponent } from './components/addproducts/addproducts.component';
import { AuthService } from './services/auth.service';
import { AdminService } from './services/admin.service';
import { AllproductsComponent } from './components/allproducts/allproducts.component';
import { MyordersComponent } from './components/myorders/myorders.component';
import { AdminproductsComponent } from './components/adminproducts/adminproducts.component';
import { AdminordersComponent } from './components/adminorders/adminorders.component';
@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    UserhomeComponent,
    AdminhomeComponent,
    AdminloginComponent,
    UserloginComponent,
    UserregisterComponent,
    AdminregisterComponent,
    PageNotFoundComponent,
    AddProductComponent,
    AllproductsComponent,
    MyordersComponent,
    AdminproductsComponent,
    AdminordersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatSnackBarModule,
    MatCardModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    
  ],
  providers: [AuthService, AdminService

  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
