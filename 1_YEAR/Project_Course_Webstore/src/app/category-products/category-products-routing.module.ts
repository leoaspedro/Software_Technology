import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CategoryProductsComponent } from './category-products.component';
import { BikesComponent } from './bikes/bikes.component';
import { AccessoriesComponent } from './accessories/accessories.component';
import { PartsComponent } from './parts/parts.component';
import { CategoryComponent } from './category/category.component';

const categoryProductsRoutes: Routes = [
  {
    path: 'products',
    component: CategoryProductsComponent,
    children: [
      {
        path: 'bikes',
        children: [
          {
            path: '',
            component: BikesComponent,
          },
          {
            path: ':url',
            component: CategoryComponent,
          },
        ],
      },
      {
        path: 'accessories',
        children: [
          {
            path: '',
            component: AccessoriesComponent,
          },
          {
            path: ':url',
            component: CategoryComponent,
          },
        ],
      },
      {
        path: 'parts',
        children: [
          {
            path: '',
            component: PartsComponent,
          },
          {
            path: ':url',
            component: CategoryComponent,
          },
        ],
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(categoryProductsRoutes)],
  exports: [RouterModule],
})
export class CategoryProductsRoutingModule {}
