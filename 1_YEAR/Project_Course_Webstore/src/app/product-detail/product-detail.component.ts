import {
  Component,
  OnInit,
  Pipe,
  PipeTransform,
  OnDestroy,
} from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';

import { CheckoutService } from './../checkout/checkout.service';
import { ProductManagementService } from '../dashboard/product-management/product-management.service';

import { switchMap } from 'rxjs/operators';
import { Observable, Subscription } from 'rxjs';
import { Title } from '@angular/platform-browser';

@Pipe({ name: 'demoNumber' })
export class DemoNumber implements PipeTransform {
  transform(value, args: string[]): any {
    let res = [];
    for (let i = 0; i < value; i++) {
      res.push(i);
    }
    return res;
  }
}

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css'],
})
export class ProductDetailComponent implements OnInit, OnDestroy {
  product$: Observable<any>;
  quantity: number = 1;
  titleSubscription: Subscription;

  constructor(
    private route: ActivatedRoute,
    private productService: ProductManagementService,
    private checkoutService: CheckoutService,
    private title: Title
  ) {}

  ngOnInit() {
    this.product$ = this.route.paramMap.pipe(
      switchMap((params: ParamMap) =>
        this.productService.getProductByUrl(params.get('url'))
      )
    );
    this.titleSubscription = this.product$.subscribe(product =>
      this.title.setTitle(`${product.title} | Bikeshop`)
    );
  }

  ngOnDestroy() {
    this.titleSubscription.unsubscribe();
    this.quantity = 1;
  }

  changeQuantity(quantity: number): void {
    this.quantity = Number(quantity);
  }

  addToCart(id: string): void {
    this.checkoutService.addToCartByProductId(id, this.quantity);
  }

  getProductFromShoppingCart(id: string): any {
    return this.checkoutService.products.find(product => product.id === id);
  }

  undoByProductId(id: string): void {
    const index = this.checkoutService.products.findIndex(
      product => product.id === id
    );
    this.checkoutService.removeProduct(index);
    this.quantity = 1;
  }

  getDiscountPercentage(discountPrice: number, price: number): number {
    let percentage: number;
    percentage = Math.floor(100 - (discountPrice * 100) / price);
    return percentage;
  }
}
