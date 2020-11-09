import { Customer } from './register/register.component';
import { Output, Injectable, EventEmitter } from '@angular/core';

import { Router } from '@angular/router';
import { AngularFireAuth } from '@angular/fire/auth';
import { User } from 'firebase';
import { AuthService } from '../../services/auth/auth.service';
import { AngularFirestore } from '@angular/fire/firestore';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SignService {
  user: User;
  userId: string;
  isModalOpen: boolean = false;
  isLoading: boolean = false;

  @Output() currentState: EventEmitter<boolean> = new EventEmitter();
  @Output() resetFormView: EventEmitter<boolean> = new EventEmitter();
  @Output() incorrectCredentials: EventEmitter<boolean> = new EventEmitter();
  @Output() emailIsInUse: EventEmitter<boolean> = new EventEmitter();

  constructor(
    public fireAuth: AngularFireAuth,
    public firestore: AngularFirestore,
    public authService: AuthService,
    public router: Router
  ) {}

  get isLoggedIn(): Observable<string> {
    return this.authService.uid;
  }

  login(email: string, password: string): void {
    this.isLoading = true;
    this.authService.login(email, password).then(
      () => {
        this.isLoading = false;
        this.toggle();
      },
      () => {
        this.isLoading = false;
        this.incorrectCredentials.emit(true);
      }
    );
  }

  register(customer: Customer, password: string): void {
    this.isLoading = true;
    const email: string = customer.email;
    this.authService.register(email, password).then(credentials => {
      const id: string = credentials.user.uid;
      this.firestore
        .doc(`users/${id}`)
        .set(customer)
        .then(
          () => {
            this.isLoading = false;
            this.toggle();
          },
          () => {
            this.isLoading = false;
            this.toggle();
          }
        );
    });
  }

  checkIfEmailIsInUse(email: string) {
    this.fireAuth.auth
      .fetchSignInMethodsForEmail(email)
      .then((results: string[]) => {
        if (results.length != 0) {
          this.emailIsInUse.emit(true);
        }
      });
    this.emailIsInUse.emit(false);
  }

  resetEmailIsInUse() {
    this.emailIsInUse.emit(false);
  }

  toggle(): void {
    if (!this.isModalOpen) {
      document.getElementsByTagName('html')[0].style.overflow = 'hidden';
    } else {
      document.getElementsByTagName('html')[0].style.overflow = 'auto';
    }

    this.isModalOpen = !this.isModalOpen;
    this.currentState.emit(this.isModalOpen);
    this.resetFormView.emit(true);
    this.incorrectCredentials.emit(false);
  }
}
