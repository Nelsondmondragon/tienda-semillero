import { Routes } from '@angular/router';

import { HomeComponent } from '../../home/home.component';


export const AdminLayoutRoutes: Routes = [
    { path: '**', redirectTo: '/inicio', pathMatch: 'full' },
    { path: 'inicio',          component: HomeComponent }
];
