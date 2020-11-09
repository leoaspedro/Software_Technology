import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeComponent } from './home.component';
import { DealsOfDayComponent } from './deals-of-day/deals-of-day.component';

import { FireModule } from '../shared/modules/fire/fire.module';
import { SharedModule } from '../shared/shared.module';

describe('HomeComponent', () => {
  let component: HomeComponent;
  let fixture: ComponentFixture<HomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [HomeComponent, DealsOfDayComponent],
      imports: [FireModule, SharedModule],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });
  // TODO: Re-Enable when modularized
  // it('should create', () => {
  //   expect(component).toBeTruthy();
  // });
});
