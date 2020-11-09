import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-product-management',
  templateUrl: './product-management.component.html',
  styleUrls: ['./product-management.component.css'],
})
export class ProductManagementComponent implements OnInit {
  constructor(private title: Title) {
    this.title.setTitle('Product Management | Bikeshop');
  }

  ngOnInit() {}
}
