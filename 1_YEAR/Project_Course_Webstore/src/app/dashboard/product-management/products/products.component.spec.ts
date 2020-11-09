import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { AngularFirestore } from '@angular/fire/firestore';

import { ProductsComponent } from './products.component';
import { AddUpdateProductComponent } from './add-update-product/add-update-product.component';
import { ImageComponent } from './add-update-product/image/image.component';

import { FireModule } from 'src/app/shared/modules/fire/fire.module';
import { SharedModule } from 'src/app/shared/shared.module';

describe('ProductsComponent', () => {
  let component: ProductsComponent;
  let fixture: ComponentFixture<ProductsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        ProductsComponent,
        AddUpdateProductComponent,
        ImageComponent,
      ],
      imports: [
        RouterTestingModule,
        FormsModule,
        ReactiveFormsModule,
        SharedModule,
        FireModule,
      ],
      providers: [AngularFirestore],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
