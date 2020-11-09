import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'empty-state',
  templateUrl: './empty-state.component.html',
  styleUrls: ['./empty-state.component.css'],
})
export class EmptyStateComponent implements OnInit {
  @Input() hasBox: boolean;
  @Input() icon: string;
  @Input() message: string;

  constructor() {}

  ngOnInit() {}
}
