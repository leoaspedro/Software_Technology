import {
  Component,
  OnInit,
  Input,
  SimpleChanges,
  SimpleChange,
} from '@angular/core';

import { ProductManagementService } from 'src/app/dashboard/product-management/product-management.service';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

export class rating {
  comment: string;
  customerName: string;
  date: Date;
  id: string;
  isTestData: boolean;
  productId: string;
  rating: number;
}

@Component({
  selector: 'product-detail-rating-items',
  templateUrl: './rating-items.component.html',
  styleUrls: ['./rating-items.component.css'],
})
export class RatingItemsComponent implements OnInit {
  @Input() id: string;
  ratings$: Observable<any[]>;

  constructor(private productManagementService: ProductManagementService) {}

  ngOnInit() {
    this.getRatings();
  }

  getDate(timestamp: number): string {
    const date: Date = new Date(timestamp * 1000);
    return `${date.getDate()}.${date.getMonth() + 1}.${date.getFullYear()}`;
  }

  getRatings(): void {
    this.ratings$ = this.productManagementService
      .getRatingsByProductId(this.id)
      .pipe(
        map(ratings =>
          ratings.sort((a: any, b: any) => {
            if (a.date > b.date) return -1;
            if (a.date < b.date) return 1;
            return 0;
          })
        )
      );
  }
}
