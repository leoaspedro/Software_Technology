import { TestBed } from '@angular/core/testing';

import { OrderManagementService } from './order-management.service';
import { FireModule } from 'src/app/shared/modules/fire/fire.module';

describe('OrderManagementService', () => {
  beforeEach(() =>
    TestBed.configureTestingModule({
      imports: [FireModule],
    })
  );

  it('should be created', () => {
    const service: OrderManagementService = TestBed.get(OrderManagementService);
    expect(service).toBeTruthy();
  });
});
