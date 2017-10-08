import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarPageComponent } from './car-page.component';

const routes: Routes = [
  { path: '', component: CarPageComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CarRoutingModule {
}
