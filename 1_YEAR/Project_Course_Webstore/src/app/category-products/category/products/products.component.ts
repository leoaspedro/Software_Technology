import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import { CategoryProductsService } from '../../category-products.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'category-products-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
})
export class ProductsComponent implements OnInit, OnDestroy {
  @Input() id: string;
  products: any;
  subscription: Subscription;

  constructor(private categoryProductsService: CategoryProductsService) {}

  ngOnInit() {
    if (this.id) {
      this.subscription = this.categoryProductsService
        .getProductsByCategoryId(this.id)
        .subscribe(observable => {
          this.products = Array.from(observable);
          this.sortBy(1);
        });
    }
  }

  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }

  sortBy(sortOption: number) {
    this.products.sort(function(a: any, b: any) {
      // Name, A-Z
      if (sortOption == 1)
        return a.title.toLowerCase().localeCompare(b.title.toLowerCase());
      // Name, Z-A
      else if (sortOption == 2)
        return b.title.toLowerCase().localeCompare(a.title.toLowerCase());
      // Price, ascending
      else if (sortOption == 3) return a.price - b.price;
      // Price, descending
      else if (sortOption == 4) return b.price - a.price;
      // Rating, descending
      else if (sortOption == 5) return b.avgRating - a.avgRating;
    });
  }
}
