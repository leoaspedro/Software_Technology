import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeComponent } from './home.component';
import { DealsOfDayComponent } from './deals-of-day/deals-of-day.component';

import { SlideshowModule } from 'ng-simple-slideshow';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [HomeComponent, DealsOfDayComponent],
  imports: [CommonModule, SlideshowModule, SharedModule],
  exports: [SharedModule],
})
export class HomeModule {}
