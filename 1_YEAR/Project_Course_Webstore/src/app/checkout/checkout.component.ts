import { Component, OnInit, OnDestroy } from '@angular/core';
import { Title } from '@angular/platform-browser';

import { CheckoutService, Product } from './checkout.service';
import { AuthService } from '../shared/services/auth/auth.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css'],
})
export class CheckoutComponent implements OnInit, OnDestroy {
  constructor(
    private checkoutService: CheckoutService,
    private title: Title,
    private authService: AuthService
  ) {
    this.title.setTitle('Checkout | Bikeshop');
  }

  ngOnInit() {}

  ngOnDestroy() {
    this.checkoutService.currentStep = 0;
  }

  get products(): Product[] {
    return this.checkoutService.products;
  }

  get currentStep(): number {
    return this.checkoutService.currentStep;
  }

  get subtotal(): number {
    return this.checkoutService.subtotal;
  }

  get shippingCosts(): number {
    return this.checkoutService.shippingCosts;
  }

  get taxes(): number {
    return this.checkoutService.taxes;
  }

  get total(): number {
    return this.checkoutService.total;
  }

  get isPaymentValid(): boolean {
    return this.checkoutService.paymentDetails.isValid;
  }

  get productsQuantity(): string {
    const itemLength: number = this.checkoutService.products.length;

    if (itemLength < 2 && itemLength !== 0) {
      return `${itemLength} product`;
    } else {
      return `${itemLength} products`;
    }
  }

  get isLoading(): boolean {
    return this.checkoutService.isLoading;
  }

  get userDetails(): any {
    return this.authService.userDetails;
  }

  get orderNumber(): number {
    return this.checkoutService.orderNumber;
  }

  placeOrder(): void {
    this.checkoutService.isLoading = true;
    this.checkoutService.placeOrder().then(() => {
      this.checkoutService.isLoading = false;
      this.checkoutService.nextStep();
    });
  }

  nextStep(): void {
    this.checkoutService.nextStep();
  }
}
