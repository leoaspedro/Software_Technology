import { Component, OnInit } from '@angular/core';

import { Observable } from 'rxjs';
import { DealsOfDayService } from './deals-of-day.service';

@Component({
  selector: 'deals-of-day',
  templateUrl: './deals-of-day.component.html',
  styleUrls: ['./deals-of-day.component.css'],
})
export class DealsOfDayComponent implements OnInit {
  products$: Observable<any[]>;

  constructor(private dealsOfDayService: DealsOfDayService) {}

  ngOnInit() {
    this.products$ = this.dealsOfDayService.getDealsOfDay();
  }
}
