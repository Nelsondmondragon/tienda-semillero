import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ComicDTO } from '../../../dto/comic-dto';

@Component({
  selector: 'app-consultar-comic',
  templateUrl: './consultar-comic.component.html'
})
export class ConsultarComicComponent implements OnInit {

  public comicDTO : ComicDTO;

  constructor(private router: Router, private activateRoute : ActivatedRoute) { }

  ngOnInit(): void {
    this.comicDTO = new ComicDTO();
    this.comicDTO = <ComicDTO> this.activateRoute.snapshot.params;
  }

  public regresar() : void {
    this.router.navigate(['gestionar-comic']);
  }
}
