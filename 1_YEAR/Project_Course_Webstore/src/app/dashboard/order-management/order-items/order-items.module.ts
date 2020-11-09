import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OrderItemsComponent } from './order-items.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { OrderManagementProductsComponent } from './order-products/order-products.component';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    OrderItemsComponent,
    CustomerDetailsComponent,
    OrderManagementProductsComponent,
  ],
  imports: [CommonModule, RouterModule],
  exports: [OrderItemsComponent],
})
export class OrderItemsModule {}
