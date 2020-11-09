import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'stars',
  templateUrl: './stars.component.html',
  styleUrls: ['./stars.component.css'],
})
export class StarsComponent implements OnInit {
  @Input() rating: number;
  @Input() isLarge?: boolean;

  constructor() {}

  ngOnInit() {}
}
