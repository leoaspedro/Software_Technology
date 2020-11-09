import { Component, OnInit, OnDestroy } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AngularFireAuth } from '@angular/fire/auth';

import { CheckoutService } from '../checkout.service';
import { AuthService } from 'src/app/shared/services/auth/auth.service';
import { SignService } from 'src/app/shared/components/sign/sign.service';

import { Subscription } from 'rxjs';

@Component({
  selector: 'app-checkout-customer-data',
  templateUrl: './customer-data.component.html',
  styleUrls: ['./customer-data.component.css'],
})
export class CustomerDataComponent implements OnInit, OnDestroy {
  form: FormGroup;
  subscription: Subscription;

  constructor(
    private checkoutService: CheckoutService,
    private title: Title,
    private authService: AuthService,
    private signService: SignService,
    private formBuilder: FormBuilder,
    private fireAuth: AngularFireAuth
  ) {
    this.title.setTitle('Customer Data - Checkout | Bikeshop');
    this.form = this.formBuilder.group({
      email: ['', Validators.required],
      fullname: ['', Validators.required],
      address: ['', Validators.required],
      country: ['', Validators.required],
      city: ['', Validators.required],
      zip: ['', Validators.required],
    });
    this.subscription = this.fireAuth.authState.subscribe(user => {
      if (user) {
        this.authService.getUserDetails().then(data => {
          this.form = this.formBuilder.group({
            email: [data.email, Validators.required],
            fullname: [data.name, Validators.required],
            address: [data.address, Validators.required],
            country: [data.country, Validators.required],
            city: [data.city, Validators.required],
            zip: [data.postal, Validators.required],
          });
        });
      }
    });
  }

  ngOnInit() {}

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  get isLoggedIn(): boolean {
    return this.authService.isLoggedIn;
  }

  get userDetails(): any {
    return this.authService.userDetails;
  }

  previousStep(): void {
    this.checkoutService.previousStep();
  }

  nextStep(): void {
    this.checkoutService.nextStep();
  }

  toggleModal(): void {
    this.signService.toggle();
  }
}
