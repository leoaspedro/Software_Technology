import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { AngularFirestore } from '@angular/fire/firestore';

import { combineLatest, BehaviorSubject, Subscription, Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
})
export class SearchComponent implements OnInit {
  @Input() isActive: boolean;
  @Output() deactivate: EventEmitter<boolean> = new EventEmitter<boolean>();
  subscriptions: Subscription[] = [];
  searchterm: string;
  startAt$: BehaviorSubject<string | null> = new BehaviorSubject(null);
  endAt$: BehaviorSubject<string | null> = new BehaviorSubject(null);
  categories$: any[];
  products$: any[];

  constructor(private angularFirestore: AngularFirestore) {}

  ngOnInit() {
    this.subscriptions.push(this.CategoriesSubscription);
    this.subscriptions.push(this.ProductsSubscription);
  }

  ngOnDestroy() {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

  get CategoriesSubscription(): Subscription {
    return this.getCategories().subscribe(categories => {
      this.categories$ = categories;
    });
  }

  get ProductsSubscription(): Subscription {
    return this.getProducts().subscribe(products => {
      this.products$ = products;
    });
  }

  getUrlTopic(topic: string): 'bikes' | 'accessories' | 'parts' {
    switch (topic) {
      case 'Bike':
        return 'bikes';
      case 'Accessory':
        return 'accessories';
      case 'Part':
        return 'parts';
    }
  }

  toggleModal(): void {
    this.searchterm = '';
    this.startAt$.next('');
    this.endAt$.next('');
    this.deactivate.emit(false);
  }

  search(e: any): void {
    const q = e.target.value.toLowerCase();
    this.startAt$.next(q);
    this.endAt$.next(q + '\uf8ff');
  }

  handleRedirect(): void {
    this.searchterm = '';
    this.startAt$.next('');
    this.endAt$.next('');
    this.toggleModal();
  }

  getDiscountPercentage(discountPrice: number, price: number): number {
    let percentage: number;
    percentage = Math.floor(100 - (discountPrice * 100) / price);
    return percentage;
  }

  getCategories(): Observable<any[]> {
    return this.getSearchResults(this.startAt$, this.endAt$, 'categories', 3);
  }

  getProducts(): Observable<any[]> {
    return this.getSearchResults(this.startAt$, this.endAt$, 'products', 5);
  }

  getSearchResults(
    start: BehaviorSubject<string>,
    end: BehaviorSubject<string>,
    collection: string,
    limit: number
  ): Observable<any[]> {
    return combineLatest(start, end).pipe(
      switchMap(([startAt, endAt]) =>
        this.angularFirestore
          .collection(collection, ref => {
            return ref
              .orderBy('searchName')
              .startAt(startAt)
              .endAt(endAt)
              .limit(limit);
          })
          .valueChanges()
      )
    );
  }
}
