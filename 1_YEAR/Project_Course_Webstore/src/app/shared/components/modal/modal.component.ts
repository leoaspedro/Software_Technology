import { Component, OnInit, Input } from '@angular/core';

import { ModalService } from './modal.service';

@Component({
  selector: 'modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css'],
})
export class ModalComponent implements OnInit {
  constructor(private modalService: ModalService) {}

  ngOnInit() {}

  get isActive(): boolean {
    return this.modalService.isActive;
  }
}
