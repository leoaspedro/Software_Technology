import { Component, OnInit, Input } from '@angular/core';
import { OrderManagementService } from '../../order-management.service';

@Component({
  selector: 'app-order-products',
  templateUrl: './order-products.component.html',
  styleUrls: ['./order-products.component.css'],
})
export class OrderManagementProductsComponent implements OnInit {
  @Input() order: any;
  products$: Promise<any[]>;

  constructor(private orderManagementService: OrderManagementService) {}

  ngOnInit() {
    this.products$ = this.getProductsByOrderId(this.order.id);
    this.products$.finally(
      () => (this.orderManagementService.isLoadingProducts = false)
    );
  }

  getProductsByOrderId(id: string): Promise<any[]> {
    return this.orderManagementService.getProductsByOrderId(id);
  }

  getTaxes(products: any): number {
    return this.getTotal(products) * 0.07;
  }

  getTotal(products: any): number {
    let sum = 0;
    for (let i = 0; i < products.length; i++) {
      sum += products[i].price * products[i].quantity;
    }
    return sum;
  }
}
