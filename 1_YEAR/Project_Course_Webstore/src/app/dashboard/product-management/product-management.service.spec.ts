import { TestBed } from '@angular/core/testing';

import { FireModule } from 'src/app/shared/modules/fire/fire.module';
import { ProductsModule } from './products/products.module';
import { CategoriesModule } from './categories/categories.module';

import { ProductManagementService } from './product-management.service';

describe('ProductManagementService', () => {
  beforeEach(() =>
    TestBed.configureTestingModule({
      imports: [FireModule, ProductsModule, CategoriesModule],
    })
  );

  it('should be created', () => {
    const service: ProductManagementService = TestBed.get(
      ProductManagementService
    );
    expect(service).toBeTruthy();
  });
});
