import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DealsOfDayComponent } from './deals-of-day.component';

import { FireModule } from 'src/app/shared/modules/fire/fire.module';
import { SharedModule } from 'src/app/shared/shared.module';

describe('DealsOfDayComponent', () => {
  let component: DealsOfDayComponent;
  let fixture: ComponentFixture<DealsOfDayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [DealsOfDayComponent],
      imports: [FireModule, SharedModule],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DealsOfDayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });
  // TODO: Re-Enable when modularized
  // it('should create', () => {
  //   expect(component).toBeTruthy();
  // });
});
