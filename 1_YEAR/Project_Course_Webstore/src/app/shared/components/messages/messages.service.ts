import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class MessagesService {
  isSuccess: boolean = false;
  isFail: boolean = false;

  constructor() {}

  toggleSuccess(): void {
    this.isSuccess = !this.isSuccess;
  }

  toggleFail(): void {
    this.isFail = !this.isFail;
  }
}
