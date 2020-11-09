import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

import { HeaderComponent } from './header.component';

import { SearchModule } from './search/search.module';

@NgModule({
  declarations: [HeaderComponent],
  imports: [CommonModule, SearchModule, RouterModule],
  exports: [HeaderComponent],
  bootstrap: [HeaderComponent],
})
export class HeaderModule {}
