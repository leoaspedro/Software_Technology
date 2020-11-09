import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { SignService } from '../sign.service';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit, OnDestroy {
  hasEmailError: boolean = false;
  hasPasswordError: boolean = false;
  incorrectCredentials: boolean = false;
  loginForm: FormGroup;
  currentStateSubscription: Subscription;
  credentialSubscription: Subscription;

  constructor(
    private formBuilder: FormBuilder,
    private signService: SignService,
    private router: Router
  ) {}

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
    });
    this.currentStateSubscription = this.signService.currentState.subscribe(
      modalIsOpen => {
        if (!modalIsOpen) {
          this.loginForm.reset();
          this.hasEmailError = false;
          this.hasPasswordError = false;
          this.incorrectCredentials = false;
        }
      }
    );
    this.credentialSubscription = this.signService.incorrectCredentials.subscribe(
      ic => {
        this.incorrectCredentials = ic;
      }
    );
  }

  ngOnDestroy() {
    this.currentStateSubscription.unsubscribe();
    this.credentialSubscription.unsubscribe();
  }

  get isLoading(): boolean {
    return this.signService.isLoading;
  }

  forgetPasswordClick(): void {
    this.signService.toggle();
    this.router.navigate(['/forgot-password']);
  }

  showEmailError(state: any): void {
    this.hasEmailError = state;
    this.incorrectCredentials = false;
  }

  showPasswordError(state: any): void {
    this.hasPasswordError = state;
    this.incorrectCredentials = false;
  }

  onSubmit(): void {
    this.signService.login(
      this.loginForm.value.email,
      this.loginForm.value.password
    );
  }
}
