import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { CheckoutService } from './checkout.service';

import { FireModule } from '../shared/modules/fire/fire.module';

describe('CheckoutService', () => {
  beforeEach(() =>
    TestBed.configureTestingModule({
      imports: [FireModule, RouterTestingModule],
    })
  );

  it('should be created', () => {
    const service: CheckoutService = TestBed.get(CheckoutService);
    expect(service).toBeTruthy();
  });
});
