import { Component, OnInit, Input } from '@angular/core';
import { OrderManagementService } from '../../order-management.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css'],
})
export class CustomerDetailsComponent implements OnInit {
  @Input() id: string;
  details$: Observable<any>;

  constructor(private orderManagementService: OrderManagementService) {}

  ngOnInit() {
    this.details$ = this.getCustomerDetailsById(this.id);
  }

  getCustomerDetailsById(id: string): Observable<any> {
    return this.orderManagementService.getCustomerDetailsById(id);
  }
}
