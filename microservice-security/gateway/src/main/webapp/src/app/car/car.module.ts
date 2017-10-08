import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarPageComponent } from './car-page.component';
import { CarRoutingModule } from './car-routing.module';
import { CarListComponent } from './car-list/car-list.component';
import { CarService } from './services/car.service';

@NgModule({
  imports: [
    CommonModule,
    CarRoutingModule
  ],
  declarations: [CarPageComponent, CarListComponent],
  providers: [
    CarService
  ],
})
export class CarModule {
}
