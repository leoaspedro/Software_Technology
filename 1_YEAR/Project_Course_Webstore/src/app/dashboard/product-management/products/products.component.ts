import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { ProductManagementService } from '../product-management.service';
import { switchMap } from 'rxjs/operators';
import { ProductsService } from './products.service';

@Component({
  selector: 'product-management-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css'],
})
export class ProductsComponent implements OnInit {
  products$;
  category$;

  constructor(
    private productManagementService: ProductManagementService,
    private activatedRoute: ActivatedRoute,
    private title: Title,
    private productService: ProductsService
  ) {
    this.title.setTitle('Product Management | Bikeshop');
  }

  ngOnInit() {
    this.products$ = this.activatedRoute.paramMap.pipe(
      switchMap((params: ParamMap) =>
        this.productManagementService.getProductsByCategoryId(params.get('id'))
      )
    );
    this.category$ = this.activatedRoute.paramMap.pipe(
      switchMap((params: ParamMap) =>
        this.productManagementService.getCategoryById(params.get('id'))
      )
    );
  }

  get itemSelected(): any {
    return this.productService.itemSelected;
  }

  get modalType(): string {
    return this.productService.modalType;
  }

  toggleModal(type: string): void {
    this.productService.modalType = type;
    this.productService.toggleModal();
  }
}
