import { TestBed } from '@angular/core/testing';

import { CategoryProductsService } from './category-products.service';
import { FireModule } from '../shared/modules/fire/fire.module';
import { AngularFirestore } from '@angular/fire/firestore';

describe('CategoryProductsService', () => {
  beforeEach(() =>
    TestBed.configureTestingModule({
      imports: [FireModule],
    })
  );

  it('should be created', () => {
    const service: CategoryProductsService = TestBed.get(
      CategoryProductsService
    );
    expect(service).toBeTruthy();
  });
});
