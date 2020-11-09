import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { SignService } from '../sign.service';

import { PasswordValidator } from './password-validator.validators';
import { Subscription } from 'rxjs';

export interface Customer {
  address: string;
  city: string;
  country: string;
  email: string;
  id: string;
  name: string;
  postal: number;
}

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit, OnDestroy {
  hasNameError: boolean = false;
  hasAddressError: boolean = false;
  hasCityError: boolean = false;
  hasPostalError: boolean = false;
  hasCountryError: boolean = false;
  hasEmailError: boolean = false;
  hasPasswordError: boolean = false;
  hasPasswordMatchError: boolean = false;
  passwordsAreValid: boolean = false;
  emailAlreadyExists: boolean = false;

  showDefault: boolean = true;

  registerForm: FormGroup;
  currentStateSubscription: Subscription;
  emailInUseSubscription: Subscription;

  customerUser: Customer = {
    address: '',
    city: '',
    country: '',
    email: '',
    id: '',
    name: '',
    postal: 0,
  };

  constructor(
    private formBuilder: FormBuilder,
    private signService: SignService
  ) {}

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      name: ['', [Validators.required, Validators.minLength(2)]],
      address: ['', Validators.required],
      city: ['', Validators.required],
      postal: ['', [Validators.required, Validators.maxLength(5)]],
      country: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: [
        '',
        [
          Validators.required,
          Validators.minLength(8),
          Validators.maxLength(20),
          PasswordValidator,
        ],
      ],
    });

    this.currentStateSubscription = this.signService.currentState.subscribe(
      modalIsOpen => {
        if (!modalIsOpen) {
          this.registerForm.reset();
          this.hasNameError = false;
          this.hasAddressError = false;
          this.hasCityError = false;
          this.hasPostalError = false;
          this.hasCountryError = false;
          this.hasEmailError = false;
          this.hasPasswordError = false;
          this.hasPasswordMatchError = false;
          this.signService.resetEmailIsInUse();
        }
      }
    );

    this.emailInUseSubscription = this.signService.emailIsInUse.subscribe(
      response => {
        this.emailAlreadyExists = response;
      }
    );
  }

  ngOnDestroy() {
    this.currentStateSubscription.unsubscribe();
    this.emailInUseSubscription.unsubscribe();
  }

  get isLoading(): boolean {
    return this.signService.isLoading;
  }

  showError(type: string, state: boolean): void {
    switch (type) {
      case 'name': {
        this.hasNameError = state;
        break;
      }
      case 'address': {
        this.hasAddressError = state;
        break;
      }
      case 'city': {
        this.hasCityError = state;
        break;
      }
      case 'postal': {
        this.hasPostalError = state;
        break;
      }
      case 'country': {
        this.hasCountryError = state;
        break;
      }
      case 'email': {
        this.hasEmailError = state;
        if (state && !this.registerForm.get('email').errors) {
          this.signService.checkIfEmailIsInUse(this.registerForm.value.email);
        }
        if (!state) this.signService.resetEmailIsInUse();
        break;
      }
      case 'password': {
        this.hasPasswordError = state;
        break;
      }
    }
  }

  comparePasswords(password: string): void {
    if (this.registerForm.get('password').value != password) {
      this.hasPasswordMatchError = true;
      this.passwordsAreValid = false;
    } else {
      this.hasPasswordMatchError = false;
      this.passwordsAreValid = true;
    }
  }

  isFirstPageValid(): boolean {
    return (
      this.registerForm.get('name').valid &&
      this.registerForm.get('address').valid &&
      this.registerForm.get('city').valid &&
      this.registerForm.get('postal').valid &&
      this.registerForm.get('country').valid
    );
  }

  showDefaultRegStep(state: boolean): void {
    this.showDefault = state;
  }

  onSubmit(): void {
    this.customerUser.address = this.registerForm.value.address;
    this.customerUser.city = this.registerForm.value.city;
    this.customerUser.country = this.registerForm.value.country;
    this.customerUser.email = this.registerForm.value.email;
    this.customerUser.name = this.registerForm.value.name;
    this.customerUser.postal = this.registerForm.value.postal;
    this.signService.register(
      this.customerUser,
      this.registerForm.value.password
    );
  }
}
