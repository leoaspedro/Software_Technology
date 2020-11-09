import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { OrderManagementComponent } from './order-management.component';

import { SharedModule } from 'src/app/shared/shared.module';
import { OrderItemsModule } from './order-items/order-items.module';

@NgModule({
  declarations: [OrderManagementComponent],
  imports: [CommonModule, RouterModule, OrderItemsModule, SharedModule],
})
export class OrderManagementModule {}
