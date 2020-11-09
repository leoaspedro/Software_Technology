import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { ProductItemComponent } from './components/product-item/product-item.component';
import { FooterComponent } from './components/footer/footer.component';
import { EmptyStateComponent } from './components/empty-state/empty-state.component';

import { FireModule } from './modules/fire/fire.module';
import { HeaderModule } from './components/header/header.module';
import { MessagesModule } from './components/messages/messages.module';
import { SignModule } from './components/sign/sign.module';

import { AuthGuardService } from './guards/auth/auth-guard.service';
import { StarsComponent } from './components/stars/stars.component';
import { ModalComponent } from './components/modal/modal.component';

@NgModule({
  declarations: [
    ProductItemComponent,
    FooterComponent,
    EmptyStateComponent,
    StarsComponent,
    ModalComponent,
  ],
  imports: [
    RouterModule,
    CommonModule,
    HeaderModule,
    SignModule,
    FireModule,
    MessagesModule,
  ],
  providers: [AuthGuardService],
  exports: [
    ProductItemComponent,
    FooterComponent,
    StarsComponent,
    EmptyStateComponent,
    ModalComponent,
    HeaderModule,
    MessagesModule,
    SignModule,
  ],
})
export class SharedModule {}
