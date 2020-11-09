import { Component, OnInit } from '@angular/core';
import { CategoriesService } from './categories.service';
import { ModalService } from '../../../shared/components/modal/modal.service';
import { Title } from '@angular/platform-browser';
import { Observable } from 'rxjs';

@Component({
  selector: 'product-management-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css'],
})
export class CategoriesComponent implements OnInit {
  constructor(
    private modalService: ModalService,
    private categoriesService: CategoriesService,
    private title: Title
  ) {
    this.title.setTitle('Category Management | Bikeshop');
  }

  ngOnInit() {}

  get bikes$(): Observable<any> {
    return this.categoriesService.bikes$;
  }

  get accessories$(): Observable<any> {
    return this.categoriesService.accessories$;
  }

  get parts$(): Observable<any> {
    return this.categoriesService.parts$;
  }

  toggleModal(): void {
    this.modalService.toggle();
  }
}
