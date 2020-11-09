import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { AngularFirestore } from '@angular/fire/firestore';
import { RouterTestingModule } from '@angular/router/testing';

import { RatingItemsComponent } from './rating-items.component';
import { EmptyStateComponent } from 'src/app/shared/components/empty-state/empty-state.component';
import { StarsComponent } from 'src/app/shared/components/stars/stars.component';

import { FireModule } from 'src/app/shared/modules/fire/fire.module';

describe('RatingItemsComponent', () => {
  let component: RatingItemsComponent;
  let fixture: ComponentFixture<RatingItemsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [RatingItemsComponent, EmptyStateComponent, StarsComponent],
      imports: [RouterTestingModule, FireModule],
      providers: [AngularFirestore],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RatingItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
