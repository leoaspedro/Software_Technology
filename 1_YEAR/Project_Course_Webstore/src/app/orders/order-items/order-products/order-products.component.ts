import { Component, OnInit, Input } from '@angular/core';
import { OrdersService } from '../../orders.service';
import { rating } from 'src/app/product-detail/rating-items/rating-items.component';
import { Product } from 'src/app/checkout/checkout.service';
import { AuthService } from 'src/app/shared/services/auth/auth.service';

@Component({
  selector: 'order-products',
  templateUrl: './order-products.component.html',
  styleUrls: ['./order-products.component.css'],
})
export class OrderProductsComponent implements OnInit {
  @Input() order: any;
  products$: Promise<any[]>;
  newRating: boolean = false;

  constructor(
    private ordersService: OrdersService,
    private authService: AuthService
  ) {}

  ngOnInit() {
    this.products$ = this.getProductsByOrderId(this.order.id);
    this.products$.finally(
      () => (this.ordersService.isLoadingProducts = false)
    );
  }

  setNewRating(state: boolean) {
    this.newRating = state;
  }

  setStars(rating: any, productNumber: number) {
    if (
      document.getElementById('product' + productNumber + 'star' + rating) !=
      null
    )
      document
        .getElementById('product' + productNumber + 'star' + rating)
        .setAttribute('checked', 'checked');
  }

  changeButton(state: boolean, productNumber: number) {
    this.setNewRating(state);
    if (!state) {
      document.getElementById(
        'submitButton' + productNumber
      ).firstElementChild.innerHTML = 'Update Review';
    }
  }

  getProductsByOrderId(id: string): Promise<any[]> {
    return this.ordersService.getProductsByOrderId(id, this.userDetails.name);
  }

  get userDetails() {
    return this.authService.userDetails;
  }

  // Check for input validity to prevent empty reviews
  checkValidity(productNumber: number) {
    let radioButtons: HTMLInputElement[] = [];
    let validRating: boolean = false;
    let validComment: boolean = false;

    // Check if a star has been selected
    for (let i = 0; i < 5; i++) {
      radioButtons[i] = <HTMLInputElement>(
        document.getElementsByName('rating' + productNumber)[i]
      );
      if (radioButtons[i].checked == true) {
        validRating = true;
        break;
      }
    }

    // Check if a comment has been written
    let textlength = (<HTMLInputElement>(
      document.getElementById('comment' + productNumber)
    )).value.length;
    if (textlength > 0) validComment = true;

    // Change the disabled state
    if (validComment && validRating)
      document
        .getElementById('submitButton' + productNumber)
        .removeAttribute('disabled');
    else
      document
        .getElementById('submitButton' + productNumber)
        .setAttribute('disabled', '');
  }

  sendRating(product: Product, productNumber: number, oldRatingId: string) {
    let radioButtons: HTMLInputElement[] = [];
    let ratingValue;

    for (let i = 0; i < 10; i++) {
      radioButtons[i] = <HTMLInputElement>(
        document.getElementsByName('rating' + productNumber)[i]
      );
      if (radioButtons[i].checked == true) {
        ratingValue = radioButtons[i].value;
        break;
      }
    }

    let ratingObject = new rating();

    let customerComment = <HTMLInputElement>(
      document.getElementById('comment' + productNumber)
    );

    ratingObject.comment = <string>customerComment.value;
    ratingObject.isTestData = false;
    ratingObject.productId = product.id;
    ratingObject.customerName = this.userDetails.name;
    ratingObject.date = new Date();
    ratingObject.rating = Number(ratingValue);
    ratingObject.id = '';

    // Depeding on the state of the review, use different methods for writing/updating
    if (
      document.getElementById('submitButton' + productNumber).firstElementChild
        .innerHTML == 'Submit Review'
    )
      this.ordersService.createRating(ratingObject);
    else if (
      document.getElementById('submitButton' + productNumber).firstElementChild
        .innerHTML == 'Update Review' &&
      oldRatingId == undefined
    )
      this.ordersService.updateRating2(ratingObject, this.userDetails.name);
    else this.ordersService.updateRating(ratingObject, oldRatingId);

    this.changeButton(false, productNumber);
  }
}
