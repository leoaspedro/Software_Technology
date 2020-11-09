import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ModalService {
  isActive: boolean = false;

  constructor() {}

  toggle() {
    if (!this.isActive) {
      document.getElementsByTagName('html')[0].style.overflow = 'hidden';
    } else {
      document.getElementsByTagName('html')[0].style.overflow = 'auto';
    }
    this.isActive = !this.isActive;
  }
}
