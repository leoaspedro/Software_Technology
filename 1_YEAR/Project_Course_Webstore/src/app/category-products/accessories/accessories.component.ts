import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';

import { Observable } from 'rxjs';
import { CategoriesService } from 'src/app/dashboard/product-management/categories/categories.service';

@Component({
  selector: 'app-accessories',
  templateUrl: './accessories.component.html',
  styleUrls: ['./accessories.component.css'],
})
export class AccessoriesComponent implements OnInit {
  constructor(
    private categoriesService: CategoriesService,
    private title: Title
  ) {
    this.title.setTitle('Accessories | Bikeshop');
  }

  ngOnInit() {}

  get accessories$(): Observable<any[]> {
    return this.categoriesService.accessories$;
  }
}
