import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { OrdersComponent } from './orders.component';
import { OrderItemsComponent } from './order-items/order-items.component';
import { OrderProductsComponent } from './order-items/order-products/order-products.component';

import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [OrdersComponent, OrderItemsComponent, OrderProductsComponent],
  imports: [CommonModule, RouterModule, SharedModule],
})
export class OrdersModule {}
