import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { CheckoutComponent } from './checkout.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { CustomerDataComponent } from './customer-data/customer-data.component';
import { ShippingComponent } from './shipping/shipping.component';
import { PaymentComponent } from './payment/payment.component';
import { OverviewComponent } from './overview/overview.component';

import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [
    CheckoutComponent,
    ShoppingCartComponent,
    CustomerDataComponent,
    ShippingComponent,
    PaymentComponent,
    OverviewComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule,
  ],
  exports: [ShoppingCartComponent],
})
export class CheckoutModule {}
