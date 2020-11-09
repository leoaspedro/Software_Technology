import { Component, OnInit, Input } from '@angular/core';

import { ProductsService } from 'src/app/dashboard/product-management/products/products.service';

@Component({
  selector: 'product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css'],
})
export class ProductItemComponent implements OnInit {
  @Input() product: any;
  @Input() isModeProductManagement?: boolean;
  @Input() isModeCustomerView?: boolean;

  constructor(private productService: ProductsService) {}

  ngOnInit() {}

  getDiscountPercentage(discountPrice: number, price: number): number {
    let percentage: number;
    percentage = Math.floor(100 - (discountPrice * 100) / price);
    return percentage;
  }

  changeDealStatus(product: any): void {
    this.productService.changeDealOfDay(product);
  }

  updateProduct(item: any): void {
    this.productService.updateProduct(item);
  }
}
