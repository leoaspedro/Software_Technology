import { Component, OnInit, OnDestroy } from '@angular/core';
import { SignService } from './sign.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'sign',
  templateUrl: './sign.component.html',
  styleUrls: ['./sign.component.css'],
})
export class SignComponent implements OnInit, OnDestroy {
  modalIsOpen: boolean = false;
  showDefault: boolean = true;
  currentStateSubscription: Subscription;
  resetFormSubscription: Subscription;

  constructor(private signService: SignService) {}

  ngOnInit() {
    this.currentStateSubscription = this.signService.currentState.subscribe(
      modalIsOpen => {
        this.modalIsOpen = modalIsOpen;
      }
    );

    this.resetFormSubscription = this.signService.resetFormView.subscribe(
      shouldResetView => {
        this.showDefault = shouldResetView;
      }
    );
  }

  ngOnDestroy() {
    if (this.currentStateSubscription) {
      this.currentStateSubscription.unsubscribe();
    }
    if (this.resetFormSubscription) {
      this.resetFormSubscription.unsubscribe();
    }
  }

  toggleModal(): void {
    this.signService.toggle();
  }

  showLoginForm(): void {
    this.showDefault = true;
  }

  showRegisterForm(): void {
    this.showDefault = false;
  }
}
