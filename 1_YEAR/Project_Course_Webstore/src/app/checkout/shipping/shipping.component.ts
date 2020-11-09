import { Component, OnInit, OnDestroy } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { CheckoutService } from '../checkout.service';
import { Subscription } from 'rxjs';

export interface Shipping {
  id: number;
  name: string;
  price: number;
  time: string;
}

@Component({
  selector: 'app-checkout-shipping',
  templateUrl: './shipping.component.html',
  styleUrls: ['./shipping.component.css'],
})
export class ShippingComponent implements OnInit, OnDestroy {
  subscription: Subscription;
  form: FormGroup;
  shippings: Shipping[] = [
    {
      id: 0,
      name: 'UPS Ground',
      price: 2.2,
      time: '3-5 days',
    },
    {
      id: 1,
      name: 'UPS 3 Day Select',
      price: 5.5,
      time: '2-3 days',
    },
    {
      id: 2,
      name: 'UPS 2nd Day Air',
      price: 9.5,
      time: '2 days',
    },
    {
      id: 3,
      name: 'UPS Next Day Air',
      price: 12.5,
      time: '1 day',
    },
    {
      id: 4,
      name: 'Same Day',
      price: 24.9,
      time: '< 1 hour',
    },
  ];

  constructor(
    private checkoutService: CheckoutService,
    private title: Title,
    private formBuilder: FormBuilder
  ) {
    this.title.setTitle('Shipping - Checkout | Bikeshop');
    this.form = this.formBuilder.group({
      id: [0, Validators.required],
    });
    this.subscription = this.form.valueChanges.subscribe(value =>
      this.updateShippingMethod(value.id)
    );
  }

  ngOnInit() {
    if (this.checkoutService.shippingMethod.name === '') {
      this.checkoutService.shippingMethod = this.shippings[0];
    } else {
      this.form.setValue({ id: this.checkoutService.shippingMethod.id });
    }
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  previousStep(): void {
    this.checkoutService.previousStep();
  }

  updateShippingMethod(id: number): void {
    this.checkoutService.shippingMethod = this.shippings[id];
  }

  nextStep(): void {
    this.checkoutService.nextStep();
  }
}
