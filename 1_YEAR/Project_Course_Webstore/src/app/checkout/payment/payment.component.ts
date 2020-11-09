import { Component, OnInit, OnDestroy } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { CheckoutService } from '../checkout.service';
import { Subscription } from 'rxjs';

export interface Payment {
  number: string;
  name: string;
  date: string;
  cvv: string;
  isValid: boolean;
}

@Component({
  selector: 'app-checkout-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css'],
})
export class PaymentComponent implements OnInit, OnDestroy {
  form: FormGroup;
  formSubscription: Subscription;
  statusSubscription: Subscription;
  isLoading: boolean = false;

  constructor(
    private checkoutService: CheckoutService,
    private title: Title,
    private formBuilder: FormBuilder
  ) {
    this.title.setTitle('Payment - Checkout | Bikeshop');
    this.form = this.formBuilder.group({
      number: ['', Validators.required],
      name: ['', Validators.required],
      date: ['', Validators.required],
      cvv: ['', Validators.required],
    });

    this.formSubscription = this.form.valueChanges.subscribe(value => {
      if (
        value.number.length === 4 ||
        value.number.length === 9 ||
        value.number.length === 14
      ) {
        this.form.patchValue({ number: `${value.number} ` });
      }
      this.checkoutService.paymentDetails.number = value.number;
      this.checkoutService.paymentDetails.name = value.name;
      if (value.date.length === 2) {
        this.form.patchValue({ date: `${value.date}/` });
      }
      this.checkoutService.paymentDetails.date = value.date;
      this.checkoutService.paymentDetails.cvv = value.cvv;
    });

    this.statusSubscription = this.form.statusChanges.subscribe(value => {
      if (value === 'INVALID') {
        this.checkoutService.paymentDetails.isValid = false;
      } else {
        this.checkoutService.paymentDetails.isValid = true;
      }
    });
  }

  ngOnInit() {
    this.form.setValue({
      number: this.checkoutService.paymentDetails.number,
      name: this.checkoutService.paymentDetails.name,
      date: this.checkoutService.paymentDetails.date,
      cvv: this.checkoutService.paymentDetails.cvv,
    });
  }

  ngOnDestroy() {
    this.formSubscription.unsubscribe();
    this.statusSubscription.unsubscribe();
  }

  previousStep(): void {
    this.checkoutService.previousStep();
  }

  nextStep(): void {
    this.checkoutService.nextStep();
  }
}
