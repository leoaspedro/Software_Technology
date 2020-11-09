import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FailMessageComponent } from './fail-message.component';

describe('FailMessageComponent', () => {
  let component: FailMessageComponent;
  let fixture: ComponentFixture<FailMessageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [FailMessageComponent],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FailMessageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  // it('should create', () => {
  //   expect(component).toBeTruthy();
  // });
});
