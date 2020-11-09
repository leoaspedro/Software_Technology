import { Injectable } from '@angular/core';
import { AngularFirestore } from '@angular/fire/firestore';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class DealsOfDayService {
  constructor(private firestore: AngularFirestore) {}

  getDealsOfDay(): Observable<any[]> {
    return this.firestore
      .collection('products', ref => ref.where('isDayDeal', '==', true))
      .valueChanges();
  }
}
