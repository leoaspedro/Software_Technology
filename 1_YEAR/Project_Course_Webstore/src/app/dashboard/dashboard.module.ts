import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardComponent } from './dashboard.component';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { ProductManagementModule } from './product-management/product-management.module';
import { OrderManagementModule } from './order-management/order-management.module';

@NgModule({
  declarations: [DashboardComponent],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    ProductManagementModule,
    OrderManagementModule,
  ],
})
export class DashboardModule {}
