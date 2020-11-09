import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/shared/services/auth/auth.service';

@Component({
  selector: 'forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css'],
})
export class ForgotPasswordComponent implements OnInit {
  isLoading: boolean = false;
  isSuccess: boolean = false;
  isFail: boolean = false;
  failMessage: string = '';
  passwordResetForm: FormGroup;

  constructor(
    private title: Title,
    private authService: AuthService,
    private formBuilder: FormBuilder
  ) {
    this.title.setTitle('Forgot password | Bikeshop');
    this.passwordResetForm = this.formBuilder.group({
      email: ['', Validators.required],
    });
  }

  ngOnInit() {}

  get email(): string {
    return this.passwordResetForm.get('email').value;
  }

  retry(): void {
    this.isFail = false;
    this.failMessage = '';
  }

  sendResetPassword(): void {
    this.isLoading = true;
    this.authService.resetPassword(this.email).then(
      () => {
        this.isLoading = false;
        this.isSuccess = true;
      },
      (reason: any) => {
        this.isLoading = false;
        this.isFail = true;
        this.failMessage = reason.message;
      }
    );
  }
}
