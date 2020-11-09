import { Injectable } from '@angular/core';
import { AngularFirestore } from '@angular/fire/firestore';
import {
  AngularFireStorage,
  AngularFireUploadTask,
} from '@angular/fire/storage';
import { Observable } from 'rxjs';
import { concatMap } from 'rxjs/operators';
import { Product } from './products/add-update-product/add-update-product.component';

@Injectable({
  providedIn: 'root',
})
export class ProductManagementService {
  products$: Observable<any>;
  categories$: Observable<any>;
  dealsOfDay$: Observable<any>;
  task: AngularFireUploadTask;
  uploadProgress$: Observable<number>;
  image$: Observable<any>;
  filePath: string = '';

  constructor(
    private firestore: AngularFirestore,
    private fireStorage: AngularFireStorage
  ) {}

  getCategoryById(id: string): Observable<any> {
    return this.firestore.doc(`categories/${id}`).valueChanges();
  }

  getProductsByCategoryId(id: string): Observable<any[]> {
    return this.firestore
      .collection('products', ref => ref.where('categoryId', '==', id))
      .valueChanges();
  }

  getProductByUrl(url: string): Observable<any> {
    return this.firestore
      .collection('products', ref => ref.where('url', '==', url))
      .valueChanges()
      .pipe(concatMap(x => x));
  }

  getCustomerRatingsByProductId(id: string): Observable<any[]> {
    return this.firestore
      .collection('ratings', ref => ref.where('productId', '==', id))
      .valueChanges();
  }

  getRatingsByProductId(id: string): Observable<any[]> {
    return this.firestore.collection(`products/${id}/ratings`).valueChanges();
  }

  uploadFile(event: any): void {
    const file = event.target.files[0];
    const filePath = `images/categories/${new Date().getTime()}_${file.name}`;
    this.task = this.fireStorage.upload(filePath, file);
    this.task.then(() => {
      this.image$ = this.fireStorage.ref(filePath).getDownloadURL();
      this.filePath = filePath;
    });
    this.uploadProgress$ = this.task.percentageChanges();
  }

  deleteFile(filePath: string): Promise<any> {
    const ref = this.fireStorage.ref(filePath);
    return ref.delete().toPromise();
  }

  createProduct(productObject: Product): Promise<void> {
    const id = this.firestore.createId();
    productObject.id = id;
    return this.firestore.doc(`products/${id}`).set(productObject);
  }

  deleteProduct(id: string): Promise<void> {
    return this.firestore.doc(`products/${id}`).delete();
  }

  updateProduct(product: any): Promise<void> {
    return this.firestore.doc(`products/${product.id}`).update(product);
  }
}
