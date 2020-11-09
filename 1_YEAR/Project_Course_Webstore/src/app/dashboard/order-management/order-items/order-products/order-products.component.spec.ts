import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderManagementProductsComponent } from './order-products.component';
import { RouterModule } from '@angular/router';

describe('OrderManagementProductsComponent', () => {
  let component: OrderManagementProductsComponent;
  let fixture: ComponentFixture<OrderManagementProductsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [OrderManagementProductsComponent],
      imports: [RouterModule],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderManagementProductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  //it('should create', () => {
  //  expect(component).toBeTruthy();
  //});
});
