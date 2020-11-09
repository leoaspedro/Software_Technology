import { Injectable } from '@angular/core';
import { ModalService } from '../../../shared/components/modal/modal.service';
import { AngularFirestore } from '@angular/fire/firestore';

@Injectable({
  providedIn: 'root',
})
export class ProductsService {
  itemSelected: any;
  modalType: string = '';

  constructor(
    private modalService: ModalService,
    private firestore: AngularFirestore
  ) {}

  toggleModal(): void {
    this.modalService.toggle();
  }

  updateProduct(item: any): void {
    this.itemSelected = item;
    this.modalType = 'update';
    this.toggleModal();
  }

  changeDealOfDay(product: any): void {
    this.firestore
      .doc(`products/${product.id}`)
      .update({ isDayDeal: !product.isDayDeal });
  }
}
