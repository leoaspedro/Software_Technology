import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { ProductDetailComponent, DemoNumber } from './product-detail.component';
import { RatingItemsComponent } from './rating-items/rating-items.component';

import { SharedModule } from '../shared/shared.module';
import { GalleryComponent } from './gallery/gallery.component';

@NgModule({
  declarations: [
    ProductDetailComponent,
    RatingItemsComponent,
    DemoNumber,
    GalleryComponent,
  ],
  imports: [CommonModule, RouterModule, SharedModule],
  exports: [DemoNumber, GalleryComponent],
})
export class ProductDetailModule {}
