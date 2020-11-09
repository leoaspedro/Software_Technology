import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'fail-message',
  templateUrl: './fail-message.component.html',
  styleUrls: ['./fail-message.component.css'],
})
export class FailMessageComponent implements OnInit {
  @Input() message: string;

  constructor() {}

  ngOnInit() {}
}
