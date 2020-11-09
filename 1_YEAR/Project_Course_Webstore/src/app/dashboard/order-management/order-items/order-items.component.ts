import { Component, OnInit, Input } from '@angular/core';
import { OrderManagementService } from '../order-management.service';

@Component({
  selector: 'app-order-items',
  templateUrl: './order-items.component.html',
  styleUrls: ['./order-items.component.css'],
})
export class OrderItemsComponent implements OnInit {
  @Input() orders: any;
  toggleId: string = '';

  constructor(private orderManagementService: OrderManagementService) {}

  ngOnInit() {}

  get isLoading(): boolean {
    return this.orderManagementService.isLoadingProducts;
  }

  toggleOrderDetails(id: string): void {
    if (this.toggleId === id) {
      this.toggleId = '';
    } else {
      this.toggleId = id;
      this.orderManagementService.isLoadingProducts = true;
    }
  }

  updateStatus(id: string, customerId: string, status: string): void {
    if (status === 'delayed') {
      this.orderManagementService.updateStatusByOrderId(
        id,
        customerId,
        'Delayed'
      );
    } else {
      this.orderManagementService.updateStatusByOrderId(
        id,
        customerId,
        'Shipped'
      );
    }
  }
}
