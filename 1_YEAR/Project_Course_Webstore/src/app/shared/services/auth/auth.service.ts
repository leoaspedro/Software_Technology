import { Injectable } from '@angular/core';
import { AngularFireAuth } from '@angular/fire/auth';
import { AngularFirestore } from '@angular/fire/firestore';
import { Router } from '@angular/router';

import { User } from 'firebase';
import { map, switchMap } from 'rxjs/operators';
import { of as observableOf, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  user: User;
  modalIsOpen: boolean = false;
  isLoggedIn: boolean = false;
  isAdmin: boolean = false;
  userDetails: any;

  constructor(
    public fireAuth: AngularFireAuth,
    private firestore: AngularFirestore,
    private router: Router
  ) {
    this.fireAuth.authState.subscribe(user => {
      if (user) {
        this.user = user;
        this.isLoggedIn = true;
        localStorage.setItem('user', JSON.stringify(this.user));
        this.firestore
          .doc(`users/${this.user.uid}`)
          .ref.get()
          .then(doc => {
            if (doc.exists) {
              this.userDetails = doc.data();
            }
          });
      } else {
        this.isLoggedIn = false;
        localStorage.setItem('user', null);
      }
    });

    this.isRoleAdmin.subscribe((isRoleAdmin: boolean) => {
      if (isRoleAdmin) {
        this.isAdmin = true;
        this.router.navigate(['/dashboard']);
      }
    });
  }

  async getUserDetails(): Promise<firebase.firestore.DocumentData> {
    const data = await this.firestore
      .doc(`users/${this.user.uid}`)
      .ref.get()
      .then(doc => {
        if (doc.exists) {
          return doc.data();
        }
      });
    return data;
  }

  login(
    email: string,
    password: string
  ): Promise<firebase.auth.UserCredential> {
    return this.fireAuth.auth.signInWithEmailAndPassword(email, password);
  }

  register(
    email: string,
    password: string
  ): Promise<firebase.auth.UserCredential> {
    return this.fireAuth.auth.createUserWithEmailAndPassword(email, password);
  }

  resetPassword(email: string): Promise<void> {
    return this.fireAuth.auth.sendPasswordResetEmail(email);
  }

  logout(): void {
    this.fireAuth.auth.signOut().then(() => {
      this.isAdmin = false;
      this.userDetails = null;
      localStorage.removeItem('user');
      this.router.navigate(['/']);
    });
  }

  uid: Observable<string> = this.fireAuth.authState.pipe(
    map(authState => {
      if (!authState) {
        return null;
      } else {
        return authState.uid;
      }
    })
  );

  isRoleAdmin: Observable<boolean> = this.uid.pipe(
    switchMap(uid => {
      if (!uid) {
        return observableOf(false);
      }
      const docRef = this.firestore.doc<boolean>(`admins/${uid}`);
      return docRef.valueChanges();
    })
  );
}
