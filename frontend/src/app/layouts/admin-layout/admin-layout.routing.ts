import { Routes } from '@angular/router';

import { HomeComponent } from '../../home/home.component';
import { GestionarComicComponent } from './gestionar-comic/gestionar-comic.component';
import { ConsultarComicComponent } from './consultar-comic/consultar-comic.component';
import { CompraComicComponent } from './compra-comic/compra-comic.component';


export const AdminLayoutRoutes: Routes = [
    { path: '', redirectTo: '/inicio', pathMatch: 'full' },
    { path: 'inicio', component: HomeComponent },
    { path: 'gestionar-comic', component: GestionarComicComponent },
    { path: 'consultar-comic', component: ConsultarComicComponent },
    { path: 'comprar-comic', component: CompraComicComponent },
];
