import { Component, OnInit, ViewChild } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap, take } from 'rxjs/operators';
import { CategoryProductsService } from '../category-products.service';
import { ProductsComponent } from './products/products.component';

@Component({
  selector: 'category-products',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css'],
})
export class CategoryComponent implements OnInit {
  category$;

  @ViewChild(ProductsComponent) child: ProductsComponent;

  constructor(
    private title: Title,
    private activatedRoute: ActivatedRoute,
    private categoryProductsService: CategoryProductsService
  ) {
    this.title.setTitle('Product categories | Bikeshop');
  }

  ngOnInit() {
    this.category$ = this.activatedRoute.paramMap.pipe(
      switchMap((params: ParamMap) =>
        this.categoryProductsService.getCategoryByUrl(params.get('url'))
      )
    );
  }

  sortProducts(event: any): void {
    this.child.sortBy(event.target.value);
  }

  filterOptions: any[] = [
    { id: 1, name: 'Sort by name, A-Z' },
    { id: 2, name: 'Sort by name, Z-A' },
    { id: 3, name: 'Sort by price, ascending' },
    { id: 4, name: 'Sort by price, descending' },
    { id: 5, name: 'Sort by rating' },
  ];
}
