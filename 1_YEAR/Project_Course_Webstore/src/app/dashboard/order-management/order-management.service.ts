import { Injectable } from '@angular/core';
import { AngularFirestore } from '@angular/fire/firestore';
import { AngularFireFunctions } from '@angular/fire/functions';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class OrderManagementService {
  isLoadingProducts: boolean = false;
  isLoading: boolean = false;

  constructor(
    private firestore: AngularFirestore,
    private fireFunction: AngularFireFunctions
  ) {}

  getNewOrders(): Observable<any[]> {
    return this.firestore
      .collection('orders', ref => ref.where('status', '==', 'New'))
      .valueChanges();
  }

  getDelayedOrders(): Observable<any[]> {
    return this.firestore
      .collection('orders', ref => ref.where('status', '==', 'Delayed'))
      .valueChanges();
  }

  getShippedOrders(): Observable<any[]> {
    return this.firestore
      .collection('orders', ref => ref.where('status', '==', 'Shipped'))
      .valueChanges();
  }

  async getProductsByOrderId(id: string): Promise<any[]> {
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
              products.push(data);
            });
        }
      });
    return products;
  }

  getCustomerDetailsById(id: string): Observable<any> {
    return this.firestore.doc(`users/${id}`).valueChanges();
  }

  sendStatusEmail(orderId: string, customerId: string, status: string): void {
    this.getEmailByCustomerId(customerId).then(customerData => {
      const htmlBody = `<p>Hello ${customerData.name},</p>
      <p>we recently updated your order status to <b>${status}</b>.</p>
      <br/>
      <p>Your Bikeshop-Team</p>`;
      this.getOrderDetailsById(orderId).then(orderData => {
        const customerEmail: string = customerData.email;
        const emailSubject: string = `Order No. ${
          orderData.orderNumber
        } has been marked as *${status}*`;

        const content = {
          to: customerEmail,
          subject: emailSubject,
          text: htmlBody,
        };

        const request = {
          headers: {
            'content-type': 'application/json; charset=UTF-8',
          },
          body: content,
        };

        const callable = this.fireFunction.httpsCallable('sendEMail');
        callable(request)
          .toPromise()
          .then(() => {
            console.log('Send mail');
          });
      });
    });
  }

  async getOrderDetailsById(id: string): Promise<any> {
    const orderDetails: any = await this.firestore
      .doc(`orders/${id}`)
      .ref.get()
      .then(doc => {
        const data = doc.data();
        return data;
      });
    return orderDetails;
  }

  async getEmailByCustomerId(id: string): Promise<any> {
    const customerData: any = await this.firestore
      .doc(`users/${id}`)
      .ref.get()
      .then(doc => {
        const data = doc.data();
        return data;
      });
    return customerData;
  }

  updateStatusByOrderId(id: string, customerId: string, status: string): void {
    this.firestore
      .doc(`orders/${id}`)
      .update({ status: status })
      .then(() => {
        this.sendStatusEmail(id, customerId, status);
      });
  }
}
