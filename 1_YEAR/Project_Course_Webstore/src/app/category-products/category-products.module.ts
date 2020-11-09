import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CategoryProductsComponent } from './category-products.component';
import { CategoryComponent } from './category/category.component';
import { BikesComponent } from './bikes/bikes.component';
import { AccessoriesComponent } from './accessories/accessories.component';
import { PartsComponent } from './parts/parts.component';
import { ProductsComponent } from './category/products/products.component';

import { CategoryProductsRoutingModule } from './category-products-routing.module';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [
    CategoryProductsComponent,
    CategoryComponent,
    BikesComponent,
    AccessoriesComponent,
    PartsComponent,
    ProductsComponent,
  ],
  imports: [CommonModule, CategoryProductsRoutingModule, SharedModule],
})
export class CategoryProductsModule {}
