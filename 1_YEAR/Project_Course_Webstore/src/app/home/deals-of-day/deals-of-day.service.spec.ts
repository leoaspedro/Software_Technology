import { TestBed } from '@angular/core/testing';

import { DealsOfDayService } from './deals-of-day.service';
import { FireModule } from 'src/app/shared/modules/fire/fire.module';

describe('DealsOfDayService', () => {
  beforeEach(() =>
    TestBed.configureTestingModule({
      imports: [FireModule],
    })
  );

  it('should be created', () => {
    const service: DealsOfDayService = TestBed.get(DealsOfDayService);
    expect(service).toBeTruthy();
  });
});
