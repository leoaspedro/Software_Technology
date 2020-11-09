import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'product-management-category-items',
  templateUrl: './category-items.component.html',
  styleUrls: ['./category-items.component.css'],
})
export class CategoryItemsComponent implements OnInit {
  @Input() items: any;

  constructor() {}

  ngOnInit() {}
}
