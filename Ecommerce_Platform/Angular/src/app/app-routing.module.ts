import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './components/homepage/homepage.component';

import { AdminhomeComponent } from './components/adminhome/adminhome.component';
import { UserhomeComponent } from './components/userhome/userhome.component';
import { AdminloginComponent } from './components/adminlogin/adminlogin.component';
import { AdminregisterComponent } from './components/adminregister/adminregister.component';
import { UserloginComponent } from './components/userlogin/userlogin.component';
import { UserregisterComponent } from './components/userregister/userregister.component';
import { AddProductComponent } from './components/addproducts/addproducts.component';
import { AllproductsComponent } from './components/allproducts/allproducts.component';
import { MyordersComponent } from './components/myorders/myorders.component';
import { AdminproductsComponent } from './components/adminproducts/adminproducts.component';
import { AdminordersComponent } from './components/adminorders/adminorders.component';


const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomepageComponent },
  { path: 'adminlogin', component: AdminloginComponent},
  { path: 'adminregister', component: AdminregisterComponent},
  { path: 'adminhome/:id', component: AdminhomeComponent},
  { path: 'adminhome', component: AdminhomeComponent},

  { path: 'userlogin', component: UserloginComponent},
  { path: 'userregister', component: UserregisterComponent},
  { path: 'userhome/:id', component: UserhomeComponent },
  { path: 'userhome', component: UserhomeComponent },


  { path: 'addproducts/:id', component: AddProductComponent},
  { path: 'allproducts/:id', component: AllproductsComponent},

  { path: 'myorders/:id', component: MyordersComponent},
  { path: 'adminproducts/:id', component: AdminproductsComponent},
  { path: 'adminorders/:id', component: AdminordersComponent},



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
