import { Component, OnInit, OnDestroy } from '@angular/core';
import { Title } from '@angular/platform-browser';

import { CheckoutService, Product } from '../checkout.service';

import { AuthService } from 'src/app/shared/services/auth/auth.service';
import { Shipping } from '../shipping/shipping.component';
import { Payment } from '../payment/payment.component';

@Component({
  selector: 'app-checkout-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.css'],
})
export class OverviewComponent implements OnInit, OnDestroy {
  constructor(
    private checkoutService: CheckoutService,
    private title: Title,
    private authService: AuthService
  ) {
    this.title.setTitle('Confirmation - Checkout | Bikeshop');
  }

  ngOnInit() {}

  ngOnDestroy() {
    this.checkoutService.products = [];
    this.checkoutService.orderNumber = 0;
    this.checkoutService.paymentDetails = {
      number: '',
      name: '',
      date: '',
      cvv: '',
      isValid: false,
    };
    this.checkoutService.shippingMethod = {
      id: 0,
      name: '',
      price: 0,
      time: '',
    };
  }

  get shippingMethod(): Shipping {
    return this.checkoutService.shippingMethod;
  }

  get paymentDetails(): Payment {
    return this.checkoutService.paymentDetails;
  }

  get products(): Product[] {
    return this.checkoutService.products;
  }

  get userDetails(): any {
    return this.authService.userDetails;
  }

  get total(): number {
    return this.checkoutService.total;
  }

  get shippingCosts(): number {
    return this.checkoutService.shippingCosts;
  }

  get taxes(): number {
    return this.checkoutService.taxes;
  }

  getDiscountPercentage(discountPrice: number, price: number): number {
    return this.checkoutService.getDiscountPercentage(discountPrice, price);
  }
}
