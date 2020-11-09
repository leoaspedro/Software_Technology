import { Component, OnInit, Input } from '@angular/core';

import { OrdersService } from '../orders.service';

@Component({
  selector: 'order-items',
  templateUrl: './order-items.component.html',
  styleUrls: ['./order-items.component.css'],
})
export class OrderItemsComponent implements OnInit {
  @Input() orders: any;
  toggleId: string = '';

  constructor(private ordersService: OrdersService) {}

  ngOnInit() {}

  get isLoading(): boolean {
    return this.ordersService.isLoadingProducts;
  }

  getDate(timestamp: number): string {
    const date: Date = new Date(timestamp * 1000);
    const weekday = new Array(7);
    weekday[0] = 'Sunday';
    weekday[1] = 'Monday';
    weekday[2] = 'Tuesday';
    weekday[3] = 'Wednesday';
    weekday[4] = 'Thursday';
    weekday[5] = 'Friday';
    weekday[6] = 'Saturday';
    return `${weekday[date.getDay()]}, ${date.getDate()}.${date.getMonth() +
      1}.${date.getFullYear()} - ${date.getHours()}:${(date.getMinutes() < 10
      ? '0'
      : '') + date.getMinutes()}`;
  }

  toggleOrderDetails(id: string): void {
    if (this.toggleId === id) {
      this.toggleId = '';
    } else {
      this.toggleId = id;
      this.ordersService.isLoadingProducts = true;
    }
  }
}
