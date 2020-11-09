import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { ProductsComponent } from './products.component';

import { SharedModule } from 'src/app/shared/shared.module';
import { ImageComponent } from './add-update-product/image/image.component';
import { AddUpdateProductComponent } from './add-update-product/add-update-product.component';

@NgModule({
  declarations: [ProductsComponent, ImageComponent, AddUpdateProductComponent],
  imports: [
    CommonModule,
    RouterModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule,
  ],
})
export class ProductsModule {}
