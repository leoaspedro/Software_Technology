import { Injectable } from '@angular/core';
import { AngularFirestore } from '@angular/fire/firestore';
import { Observable, BehaviorSubject } from 'rxjs';

import { Category } from './add-category/add-category.component';
import { switchMap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class CategoriesService {
  bikes$: Observable<any>;
  accessories$: Observable<any>;
  parts$: Observable<any>;
  topicBikes$: BehaviorSubject<string | null>;
  topicAccessories$: BehaviorSubject<string | null>;
  topicParts$: BehaviorSubject<string | null>;

  constructor(private firestore: AngularFirestore) {
    this.getTopicByName(this.topicBikes$, 'Bike');
    this.getTopicByName(this.topicAccessories$, 'Accessory');
    this.getTopicByName(this.topicParts$, 'Part');
  }

  getTopicByName(topic$: BehaviorSubject<string | null>, name: string) {
    topic$ = new BehaviorSubject(null);
    const query = topic$.pipe(
      switchMap(topic =>
        this.firestore
          .collection('categories', ref => {
            let query:
              | firebase.firestore.CollectionReference
              | firebase.firestore.Query = ref;
            query = query.where('topic', '==', topic);
            return query;
          })
          .valueChanges()
      )
    );

    if (name === 'Bike') {
      this.bikes$ = query;
    }
    if (name === 'Accessory') {
      this.accessories$ = query;
    }
    if (name === 'Part') {
      this.parts$ = query;
    }
    topic$.next(name);
  }

  createCategory(categoryObject: Category): Promise<void> {
    const id = this.firestore.createId();
    categoryObject.id = id;
    return this.firestore.doc(`categories/${id}`).set(categoryObject);
  }
}
