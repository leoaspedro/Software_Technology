import { Injectable, Output, EventEmitter } from '@angular/core';
import { AngularFirestore } from '@angular/fire/firestore';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CategoryProductsService {
  constructor(private firestore: AngularFirestore) {}

  getCategoryByUrl(url: string): Observable<any[]> {
    return this.firestore
      .collection('categories', ref => ref.where('url', '==', url))
      .valueChanges();
  }

  getProductsByCategoryId(id: string): Observable<any[]> {
    return this.firestore
      .collection('products', ref => ref.where('categoryId', '==', id))
      .valueChanges();
  }
}
