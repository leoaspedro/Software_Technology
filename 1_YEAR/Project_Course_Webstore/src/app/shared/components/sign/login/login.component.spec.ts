import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';

import { LoginComponent } from './login.component';

import { FireModule } from 'src/app/shared/modules/fire/fire.module';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let email: any;
  let password: any;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [LoginComponent],
      imports: [
        FormsModule,
        ReactiveFormsModule,
        FireModule,
        RouterTestingModule,
      ],
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    email = component.loginForm.controls['email'];
    password = component.loginForm.controls['password'];
  });

  // it('should create', () => {
  //   expect(component).toBeTruthy();
  // });
  // it('should be invalid when blank', async(() => {
  //   email.setValue('');
  //   password.setValue('');
  //   expect(component.loginForm.valid).toBeFalsy();
  // }));
  // it('should be invalid when invalid data entered', async(() => {
  //   email.setValue('abcdefg');
  //   password.setValue('123');
  //   expect(component.loginForm.valid).toBeFalsy();
  // }));
  // it('should show invalid email error', async(() => {
  //   let errors = {};
  //   email.setValue('user.mail');
  //   errors = email.errors || {};
  //   expect(errors['email']).toBeTruthy();
  // }));
  // it('should show blank email error', async(() => {
  //   let errors = {};
  //   email.setValue('');
  //   errors = email.errors || {};
  //   expect(errors['required']).toBeTruthy();
  // }));
  // it('should show blank password error', async(() => {
  //   let errors = {};
  //   password.setValue('');
  //   errors = password.errors || {};
  //   expect(errors['required']).toBeTruthy();
  // }));
  // it('should be valid with valid data', async(() => {
  //   email.setValue('user@fake.mail');
  //   password.setValue('user01');
  //   expect(component.loginForm.valid).toBeTruthy();
  // }));
});
