import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Car } from './car';
import { Http, Response } from '@angular/http';

import 'rxjs/add/operator/map';

@Injectable()
export class CarService {

  constructor(private http: Http) {
  }

  getCars(): Observable<Array<Car>> {
    return this.http.get('cars').map((res: Response) => <Car[]>res.json());
  }

}
