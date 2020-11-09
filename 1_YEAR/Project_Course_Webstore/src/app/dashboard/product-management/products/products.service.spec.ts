import { TestBed } from '@angular/core/testing';

import { ProductsService } from './products.service';
import { FireModule } from 'src/app/shared/modules/fire/fire.module';

describe('ProductsService', () => {
  beforeEach(() =>
    TestBed.configureTestingModule({
      imports: [FireModule],
    })
  );

  it('should be created', () => {
    const service: ProductsService = TestBed.get(ProductsService);
    expect(service).toBeTruthy();
  });
});
