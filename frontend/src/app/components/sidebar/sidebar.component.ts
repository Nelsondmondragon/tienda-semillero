import { Component, OnInit } from '@angular/core';

declare interface RouteInfo {
    url: string;
    title: string;
    icon: string;
    class: string;
}
export const ROUTES: RouteInfo[] = [
    { url: '/inicio', title: 'Inicio',  icon:'design_app', class: '' },
    { url: '/gestionar-comic', title: 'Gestionar comic',  icon:'location_map-big', class: '' },
    { url: '/inventario-comic', title: 'Inventario comic',  icon:'business_chart-bar-32', class: '' },
];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html'
})
export class SidebarComponent implements OnInit {
  menuItems: any[];

  constructor() { }

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }
  isMobileMenu() {
      if ( window.innerWidth > 991) {
          return false;
      }
      return true;
  };
}
