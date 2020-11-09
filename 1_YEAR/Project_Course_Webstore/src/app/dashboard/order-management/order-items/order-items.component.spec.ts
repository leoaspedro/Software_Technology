import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderItemsComponent } from './order-items.component';
import { RouterModule } from '@angular/router';
import { FireModule } from 'src/app/shared/modules/fire/fire.module';
import { AngularFirestore } from '@angular/fire/firestore';
import { OrderItemsModule } from './order-items.module';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { OrderManagementProductsComponent } from './order-products/order-products.component';
import { CommonModule } from '@angular/common';

describe('OrderItemsComponent', () => {
  let component: OrderItemsComponent;
  let fixture: ComponentFixture<OrderItemsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        OrderItemsComponent,
        CustomerDetailsComponent,
        OrderManagementProductsComponent,
      ],
      imports: [CommonModule, RouterModule],
      providers: [AngularFirestore],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  // it('should create', () => {
  //   expect(component).toBeTruthy();
  // });
});
