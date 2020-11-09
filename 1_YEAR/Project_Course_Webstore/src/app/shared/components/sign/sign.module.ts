import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { SignComponent } from './sign.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';

import { MessagesModule } from '../messages/messages.module';

@NgModule({
  declarations: [
    SignComponent,
    LoginComponent,
    RegisterComponent,
    ForgotPasswordComponent,
  ],
  imports: [CommonModule, FormsModule, ReactiveFormsModule, MessagesModule],
  exports: [SignComponent],
})
export class SignModule {}
