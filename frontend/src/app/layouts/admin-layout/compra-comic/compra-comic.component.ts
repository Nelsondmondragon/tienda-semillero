import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ComicDTO } from '../../../dto/comic-dto';
import { GestionarComicService } from '../../../services/gestionar-comic.service';
import { NgbModal, NgbModalConfig } from '@ng-bootstrap/ng-bootstrap';
import { ModalComponent } from '../modal/modal.component';
import { ModalSuccessComponent } from '../modal-success/modal-success.component';

@Component({
  selector: 'app-compra-comic',
  templateUrl: './compra-comic.component.html',
  styleUrls: ['./compra-comic.component.scss'],
  providers: [NgbModalConfig, NgbModal],
})
export class CompraComicComponent implements OnInit {

  public comicDTO: ComicDTO;

  public cantidad: number;

  public cantidadValida = true;

  constructor(private router: Router, private activateRoute: ActivatedRoute,
    private service: GestionarComicService,
    config: NgbModalConfig, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.cantidad = 0;
    this.comicDTO = new ComicDTO();
    this.comicDTO = <ComicDTO>this.activateRoute.snapshot.params;
  }

  public regresar(): void {
    this.router.navigate(['gestionar-comic']);
  }

  comprarComic(idComic: number) {
    if (this.cantidad === 0) {
      this.cantidadValida = false;
    } else {
      this.cantidadValida = true;
      this.service.comprarComic(this.comicDTO.id, this.cantidad).subscribe((data) => {
       
        this.router.navigate(['gestionar-comic']);
        const modalRef = this.modalService.open(ModalSuccessComponent);
        modalRef.componentInstance.message = data.data;


      }, error => {
        console.log(error.error.data.errorMessage);
        const modalRef = this.modalService.open(ModalComponent);
        modalRef.componentInstance.message = error.error.data.errorMessage;
      });
    }
  }
}
