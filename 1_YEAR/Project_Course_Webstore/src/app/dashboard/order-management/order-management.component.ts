import { Component, OnInit, OnDestroy } from '@angular/core';
import { Title } from '@angular/platform-browser';

import { OrderManagementService } from './order-management.service';
import { Observable, combineLatest, of, Subscription } from 'rxjs';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-order-management',
  templateUrl: './order-management.component.html',
  styleUrls: ['./order-management.component.css'],
})
export class OrderManagementComponent implements OnInit, OnDestroy {
  openOrders$: any;
  processedOrders$: any;
  openOrdersSubscription: Subscription;
  processedOrdersSubscription: Subscription;

  constructor(
    private titleService: Title,
    private orderManagementService: OrderManagementService
  ) {
    this.titleService.setTitle('Order Management | Bikeshop');
  }

  ngOnInit() {
    this.openOrdersSubscription = this.getopenOrders().subscribe(
      orders => (this.openOrders$ = orders)
    );
    this.processedOrdersSubscription = this.shippedOrders$.subscribe(
      orders => (this.processedOrders$ = orders)
    );
  }

  ngOnDestroy() {
    this.openOrdersSubscription.unsubscribe();
    this.processedOrdersSubscription.unsubscribe();
  }

  get newOrders$(): Observable<any[]> {
    return this.orderManagementService.getNewOrders();
  }

  get delayedOrders$(): Observable<any[]> {
    return this.orderManagementService.getDelayedOrders();
  }

  get shippedOrders$(): Observable<any[]> {
    return this.orderManagementService.getShippedOrders();
  }

  getopenOrders(): Observable<any[]> {
    return combineLatest(this.newOrders$, this.delayedOrders$).pipe(
      switchMap(orders => {
        const [newOrders, delayedOrders] = orders;
        const combined = [...newOrders, ...delayedOrders];
        return of(combined);
      })
    );
  }
}
