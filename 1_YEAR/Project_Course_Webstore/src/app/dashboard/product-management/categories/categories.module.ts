import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { CategoriesComponent } from './categories.component';
import { AddCategoryComponent } from './add-category/add-category.component';
import { CategoryItemsComponent } from './category-items/category-items.component';

import { SharedModule } from 'src/app/shared/shared.module';

@NgModule({
  declarations: [
    CategoriesComponent,
    AddCategoryComponent,
    CategoryItemsComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule,
  ],
})
export class CategoriesModule {}
