import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CategoriesModule } from './categories/categories.module';
import { ProductsModule } from './products/products.module';
import { ProductManagementComponent } from './product-management.component';

@NgModule({
  declarations: [ProductManagementComponent],
  imports: [CommonModule, CategoriesModule, ProductsModule],
})
export class ProductManagementModule {}
