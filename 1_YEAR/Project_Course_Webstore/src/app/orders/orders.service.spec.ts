import { TestBed } from '@angular/core/testing';

import { OrdersService } from './orders.service';

import { FireModule } from '../shared/modules/fire/fire.module';

describe('OrdersService', () => {
  beforeEach(() =>
    TestBed.configureTestingModule({
      imports: [FireModule],
    })
  );

  it('should be created', () => {
    const service: OrdersService = TestBed.get(OrdersService);
    expect(service).toBeTruthy();
  });
});
