import { Injectable } from '@angular/core';
import { AngularFirestore } from '@angular/fire/firestore';

import { Observable } from 'rxjs';
import { rating } from '../product-detail/rating-items/rating-items.component';

@Injectable({
  providedIn: 'root',
})
export class OrdersService {
  isLoadingProducts: boolean = false;
  isLoading: boolean = false;

  constructor(private firestore: AngularFirestore) {}

  getOrdersByUserId(id: string): Observable<any[]> {
    return this.firestore
      .collection('orders', ref => ref.where('customerId', '==', id))
      .valueChanges();
  }

  async getProductsByOrderId(id: string, userName: string): Promise<any[]> {
    let products: any[] = [];

    await this.firestore
      .doc(`orders/${id}`)
      .ref.get()
      .then(doc => {
        for (let i = 0; i < doc.data().products.length; i++) {
          this.firestore
            .doc(`products/${doc.data().products[i].productId}`)
            .ref.get()
            .then(async doc => {
              const data = doc.data();
              await this.firestore
                .collection(`products/${doc.data().id}/ratings`)
                .ref.get()
                .then(list => {
                  list.docs.forEach(d => {
                    if (d.data().customerName === userName) {
                      data.comment = d.data().comment;
                      data.rating = d.data().rating;
                      data.ratingId = d.data().id;
                    }
                  });
                });
              products.push(data);
            });
        }
      });
    return products;
  }

  updateRating(ratingObject: rating, ratingId: string) {
    ratingObject.id = ratingId;
    this.firestore
      .doc(`products/${ratingObject.productId}/ratings/${ratingId}`)
      .update(Object.assign({}, ratingObject));
  }

  async updateRating2(ratingObject: rating, userName: string) {
    await this.firestore
      .collection(`products/${ratingObject.productId}/ratings`)
      .ref.get()
      .then(list => {
        list.docs.forEach(d => {
          if (d.data().customerName == userName) {
            ratingObject.id = d.data().id;
          }
        });
      });
    this.firestore
      .doc(`products/${ratingObject.productId}/ratings/${ratingObject.id}`)
      .update(Object.assign({}, ratingObject));
  }

  createRating(ratingObject: rating) {
    const id = this.firestore.createId();
    ratingObject.id = id;
    this.firestore
      .doc(`products/${ratingObject.productId}/ratings/${id}`)
      .set(Object.assign({}, ratingObject));
  }
}
