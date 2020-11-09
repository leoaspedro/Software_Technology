import { Component, OnInit, OnDestroy } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { AngularFireAuth } from '@angular/fire/auth';

import { OrdersService } from './orders.service';

import { Subscription, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css'],
})
export class OrdersComponent implements OnInit, OnDestroy {
  orders$: Observable<any[]>;
  subscription: Subscription;

  constructor(
    private ordersService: OrdersService,
    private title: Title,
    private afAuth: AngularFireAuth
  ) {}

  ngOnInit() {
    this.title.setTitle('My Orders | Bikeshop');
    this.getOrders();
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  getOrders(): void {
    this.subscription = this.afAuth.authState.subscribe(user => {
      if (user) {
        this.orders$ = this.ordersService.getOrdersByUserId(user.uid).pipe(
          map(orders =>
            orders.sort((a: any, b: any) => {
              if (a.date > b.date) return -1;
              if (a.date < b.date) return 1;
              return 0;
            })
          )
        );
      }
    });
  }
}
