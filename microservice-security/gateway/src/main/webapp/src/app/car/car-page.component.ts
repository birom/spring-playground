import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Car } from './services/car';
import { CarService } from './services/car.service';

@Component({
  selector: 'app-car-page',
  templateUrl: './car-page.component.html',
  styleUrls: ['./car-page.component.css']
})
export class CarPageComponent implements OnInit {
  cars$: Observable<Array<Car>>;

  constructor(private carService: CarService) {
  }

  ngOnInit() {
    this.cars$ = this.carService.getCars();
  }

}
