import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';

import { Observable } from 'rxjs';
import { CategoriesService } from 'src/app/dashboard/product-management/categories/categories.service';

@Component({
  selector: 'app-parts',
  templateUrl: './parts.component.html',
  styleUrls: ['./parts.component.css'],
})
export class PartsComponent implements OnInit {
  constructor(
    private categoriesService: CategoriesService,
    private title: Title
  ) {
    this.title.setTitle('Parts | Bikeshop');
  }

  ngOnInit() {}

  get parts$(): Observable<any[]> {
    return this.categoriesService.parts$;
  }
}
