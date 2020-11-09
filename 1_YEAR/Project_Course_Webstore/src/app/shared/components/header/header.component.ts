import { Component, OnInit } from '@angular/core';

import { CheckoutService } from './../../../checkout/checkout.service';
import { SignService } from '../sign/sign.service';
import { AuthService } from '../../services/auth/auth.service';
import { Observable } from 'rxjs';
import { CategoriesService } from 'src/app/dashboard/product-management/categories/categories.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
  isSearchModalActive: boolean = false;
  showBurgerMenu: boolean;

  constructor(
    private signService: SignService,
    private categoriesService: CategoriesService,
    private authService: AuthService,
    private checkoutService: CheckoutService
  ) {}

  ngOnInit() {
    this.setupNavBarToggles();
  }

  setupNavBarToggles(): void {
    document.addEventListener('DOMContentLoaded', () => {
      const navbarItems = document.getElementsByClassName('navbar-link');
      const navbarDropdowns = document.getElementsByClassName(
        'navbar-dropdown'
      );
      const burgerButton = document.getElementById('burgerButton');
      for (let i = 0; i < navbarItems.length; i++) {
        const clickElement: HTMLElement = navbarItems[i] as HTMLElement;
        const dropdownElement: HTMLElement = navbarDropdowns[i] as HTMLElement;
        dropdownElement.classList.add('is-hidden-touch');
        burgerButton.addEventListener('click', () => {
          if (this.showBurgerMenu) {
            dropdownElement.classList.add('is-hidden-touch');
          } else {
            dropdownElement.classList.remove('is-hidden-touch');
          }
        });
        clickElement.addEventListener('click', () => {
          dropdownElement.classList.toggle('is-hidden-touch');
        });
      }
    });
  }

  get userDetails(): any {
    return this.authService.userDetails;
  }

  get isModalActive(): boolean {
    return this.isSearchModalActive;
  }

  get isAdmin(): boolean {
    return this.authService.isAdmin;
  }

  get isLoggedIn(): boolean {
    return this.authService.isLoggedIn;
  }

  get bikes$(): Observable<any> {
    return this.categoriesService.bikes$;
  }

  get accessories$(): Observable<any> {
    return this.categoriesService.accessories$;
  }

  get parts$(): Observable<any> {
    return this.categoriesService.parts$;
  }

  get shoppingCartAmount(): number {
    return this.checkoutService.products.length;
  }

  logout(): void {
    this.authService.logout();
  }

  toggleSearchModal(): void {
    this.isSearchModalActive = !this.isSearchModalActive;
  }

  toggleModal(): void {
    this.signService.toggle();
  }
}
