import { Injectable } from '@angular/core';
import { AngularFirestore } from '@angular/fire/firestore';

import { Shipping } from './shipping/shipping.component';
import { Payment } from './payment/payment.component';

import { AuthService } from '../shared/services/auth/auth.service';

export interface Product {
  id: string;
  imageUrl: string;
  title: string;
  price: number;
  discountPrice: number;
  isDayDeal: boolean;
  url: string;
  quantity: number;
  orgQuantity: number;
}

interface OrderProduct {
  productId: string;
  price: number;
  quantity: number;
}

interface OrderPayment {
  name: string;
  cardNumber: string;
  expireDate: string;
  cvv: string;
}

interface Order {
  id: string;
  customerId: string;
  date: Date;
  orderNumber: number;
  payment: OrderPayment;
  products: OrderProduct[];
  shippingPrice: number;
  shippingMethod: string;
  status: string;
}

@Injectable({
  providedIn: 'root',
})
export class CheckoutService {
  isLoading: boolean = false;
  currentStep: number = 0;
  orderNumber: number = 0;
  products: Product[] = [];
  shippingMethod: Shipping = {
    id: 0,
    name: '',
    price: 0,
    time: '',
  };
  paymentDetails: Payment = {
    number: '',
    name: '',
    date: '',
    cvv: '',
    isValid: false,
  };

  constructor(
    private firestore: AngularFirestore,
    private authService: AuthService
  ) {}

  get subtotal(): number {
    let sum = 0;
    for (let i = 0; i < this.products.length; i++) {
      if (this.products[i].isDayDeal) {
        sum += this.products[i].discountPrice * this.products[i].quantity;
      } else {
        sum += this.products[i].price * this.products[i].quantity;
      }
    }
    return sum;
  }

  get shippingCosts(): number {
    return this.shippingMethod.price;
  }

  get taxes(): number {
    return 0.07 * this.subtotal;
  }

  get total(): number {
    return this.subtotal + this.shippingCosts;
  }

  removeProduct(index: number): void {
    this.products.splice(index, 1);
    if (this.products.length === 0) {
      this.shippingMethod = { id: 0, name: '', price: 0, time: '' };
    }
  }

  getOrgProductQuantity(id: string): number {
    return this.products.find(product => product.id === id).orgQuantity;
  }

  async addToCartByProductId(id: string, quantity: number): Promise<void> {
    let product: Product = {
      id: '',
      title: '',
      imageUrl: '',
      discountPrice: 0,
      price: 0,
      isDayDeal: false,
      url: '',
      quantity: 0,
      orgQuantity: 0,
    };

    const data = await this.firestore
      .doc(`products/${id}`)
      .ref.get()
      .then(doc => {
        if (doc.exists) {
          return doc.data();
        }
      });

    product.id = data.id;
    product.title = data.title;
    product.imageUrl = data.coverImage.imageUrl;
    product.discountPrice = data.discountPrice;
    product.isDayDeal = data.isDayDeal;
    product.price = data.price;
    product.url = data.url;
    product.quantity = quantity;
    product.orgQuantity = data.quantity;

    if (!this.products.find(product => product.id === id)) {
      this.products.push(product);
    }
  }

  buildOrderObject(id: string): Order {
    const randomOrderNumber: number = Math.floor(
      100000000 + Math.random() * 900000000
    );
    this.orderNumber = randomOrderNumber;
    let productObject: OrderProduct[] = [];

    this.products.forEach(product => {
      let object: OrderProduct = {
        price: 0,
        productId: '',
        quantity: 0,
      };
      object.productId = product.id;
      object.quantity = product.quantity;
      if (product.isDayDeal) {
        object.price = product.discountPrice;
      } else {
        object.price = product.price;
      }
      productObject.push(object);
    });

    let orderObject: Order = {
      id: '',
      customerId: '',
      date: null,
      orderNumber: 0,
      shippingMethod: '',
      shippingPrice: 0,
      status: '',
      payment: {
        name: '',
        cardNumber: '',
        expireDate: '',
        cvv: '',
      },
      products: [],
    };
    orderObject.id = id;
    orderObject.customerId = this.authService.user.uid;
    orderObject.date = new Date();
    orderObject.orderNumber = randomOrderNumber;
    orderObject.shippingMethod = this.shippingMethod.name;
    orderObject.shippingPrice = this.shippingMethod.price;
    (orderObject.status = 'New'),
      (orderObject.payment = {
        name: this.paymentDetails.name,
        cardNumber: this.paymentDetails.number,
        expireDate: this.paymentDetails.date,
        cvv: this.paymentDetails.cvv,
      });
    orderObject.products = productObject;

    return orderObject;
  }

  placeOrder(): Promise<void> {
    const id = this.firestore.createId();
    const orderObject = this.buildOrderObject(id);
    orderObject.products.forEach(product => {
      const newQuantity: number =
        this.getOrgProductQuantity(product.productId) - product.quantity;
      this.firestore
        .doc(`products/${product.productId}`)
        .update({ quantity: newQuantity });
    });
    return this.firestore.doc(`orders/${id}`).set(orderObject);
  }

  changeQuantity(quantity: number, index: number): void {
    this.products[index].quantity = quantity;
  }

  getDiscountPercentage(discountPrice: number, price: number): number {
    let percentage: number;
    percentage = Math.floor(100 - (discountPrice * 100) / price);
    return percentage;
  }

  nextStep(): void {
    ++this.currentStep;
  }

  previousStep(): void {
    --this.currentStep;
  }
}
