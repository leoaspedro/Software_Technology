import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderManagementComponent } from './order-management.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { OrderItemsModule } from './order-items/order-items.module';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

describe('OrderManagementComponent', () => {
  let component: OrderManagementComponent;
  let fixture: ComponentFixture<OrderManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [OrderManagementComponent],
      imports: [CommonModule, RouterModule, OrderItemsModule, SharedModule],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  // it('should create', () => {
  //   expect(component).toBeTruthy();
  // });
});
