import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';

import { CheckoutService, Product } from '../checkout.service';

@Component({
  selector: 'app-checkout-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css'],
})
export class ShoppingCartComponent implements OnInit {
  constructor(private checkoutService: CheckoutService, private title: Title) {
    this.title.setTitle('Shopping Cart - Checkout | Bikeshop');
  }

  ngOnInit() {}

  get products(): Product[] {
    return this.checkoutService.products;
  }

  getDiscountPercentage(discountPrice: number, price: number): number {
    return this.checkoutService.getDiscountPercentage(discountPrice, price);
  }

  removeProduct(index: number): void {
    this.checkoutService.removeProduct(index);
  }

  changeQuantity(method: string, index: number): void {
    const productQuantity: number = this.checkoutService.products[index]
      .quantity;
    if (method === 'add') {
      this.checkoutService.changeQuantity(productQuantity + 1, index);
    } else {
      this.checkoutService.changeQuantity(productQuantity - 1, index);
    }
  }
}
