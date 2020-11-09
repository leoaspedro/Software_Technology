import { TestBed } from '@angular/core/testing';

import { CategoriesService } from './categories.service';
import { FireModule } from 'src/app/shared/modules/fire/fire.module';

describe('CategoriesService', () => {
  beforeEach(() =>
    TestBed.configureTestingModule({
      imports: [FireModule],
    })
  );

  it('should be created', () => {
    const service: CategoriesService = TestBed.get(CategoriesService);
    expect(service).toBeTruthy();
  });
});
