import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductManagementComponent } from './product-management.component';
import { ModalComponent } from '../../shared/components/modal/modal.component';
import { EmptyStateComponent } from '../../shared/components/empty-state/empty-state.component';
import { RouterTestingModule } from '@angular/router/testing';
import { FireModule } from 'src/app/shared/modules/fire/fire.module';

describe('ProductManagementComponent', () => {
  let component: ProductManagementComponent;
  let fixture: ComponentFixture<ProductManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        ProductManagementComponent,
        ModalComponent,
        EmptyStateComponent,
      ],
      imports: [RouterTestingModule, FireModule],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });
  // TODO: Reenable when duplicate declarations have been fixed
  // it('should create', () => {
  //   expect(component).toBeTruthy();
  // });
});
