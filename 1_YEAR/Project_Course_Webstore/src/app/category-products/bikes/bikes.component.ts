import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';

import { Observable } from 'rxjs';
import { CategoriesService } from 'src/app/dashboard/product-management/categories/categories.service';

@Component({
  selector: 'app-bikes',
  templateUrl: './bikes.component.html',
  styleUrls: ['./bikes.component.css'],
})
export class BikesComponent implements OnInit {
  constructor(
    private categoriesService: CategoriesService,
    private title: Title
  ) {
    this.title.setTitle('Bikes | Bikeshop');
  }

  ngOnInit() {}

  get bikes$(): Observable<any[]> {
    return this.categoriesService.bikes$;
  }
}
