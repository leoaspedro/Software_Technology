import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterTestingModule } from '@angular/router/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { SearchComponent } from './search.component';

@NgModule({
  declarations: [SearchComponent],
  imports: [
    CommonModule,
    RouterTestingModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  exports: [SearchComponent],
  bootstrap: [SearchComponent],
})
export class SearchModule {}
