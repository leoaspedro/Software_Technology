import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { AngularFirestore } from '@angular/fire/firestore';
import { RouterTestingModule } from '@angular/router/testing';

import { ProductDetailComponent } from './product-detail.component';
import { RatingItemsComponent } from './rating-items/rating-items.component';

import { FireModule } from '../shared/modules/fire/fire.module';

import { of } from 'rxjs';
import { GalleryComponent } from './gallery/gallery.component';
import { StarsComponent } from '../shared/components/stars/stars.component';

describe('ProductDetailComponent', () => {
  let component: ProductDetailComponent;
  let fixture: ComponentFixture<ProductDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        ProductDetailComponent,
        RatingItemsComponent,
        GalleryComponent,
        StarsComponent,
      ],
      imports: [RouterTestingModule, FireModule],
      providers: [
        AngularFirestore,
        {
          provide: ActivatedRoute,
          useValue: {
            params: of([{ url: 'test-bike-url' }]),
          },
        },
      ],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  // it('should create', () => {
  //   expect(component).toBeTruthy();
  // });
});
