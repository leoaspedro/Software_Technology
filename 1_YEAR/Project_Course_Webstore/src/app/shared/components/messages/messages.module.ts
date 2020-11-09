import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FailMessageComponent } from './fail-message/fail-message.component';
import { SuccessMessageComponent } from './success-message/success-message.component';

@NgModule({
  declarations: [FailMessageComponent, SuccessMessageComponent],
  imports: [CommonModule],
  exports: [FailMessageComponent, SuccessMessageComponent],
})
export class MessagesModule {}
