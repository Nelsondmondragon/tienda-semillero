import { Component, OnDestroy, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { MultiLanguage } from '../../../multilanguage/multilanguage';
import { ComicDTO } from '../../../dto/comic-dto';
import { EstadoEnum } from '../../../enums/estado-enum';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TematicaEnum } from '../../../enums/tematica-enum';
import { Router } from '@angular/router';
import { GestionarComicService } from '../../../services/gestionar-comic.service';
import { NgbModal, NgbModalConfig } from '@ng-bootstrap/ng-bootstrap';
import { data } from 'jquery';

/**
 * @description Componente que se encarga de gestionar el CRUD de un comic
 * @author dalvarez@heinsohn.com.co
 * @author pepito@heinsohn.com.co
 * @version 1.1
 */
@Component({
  selector: 'app-gestionar-comic',
  templateUrl: './gestionar-comic.component.html',
  providers: [NgbModalConfig, NgbModal],
})
export class GestionarComicComponent extends MultiLanguage implements OnInit {

  public gestionarComicForm: FormGroup;

  /**
   * Atributo que representa un parametro para el titulo de multilanguage
   */
  public parametro: string;

  // public idComic: number;
  /**
   * Atributo que contendra la lista de los comics a mostrar en la tabla
   */
  public listaComics: Array<ComicDTO>;

  public comicDto: ComicDTO;

  public mostrarMensajeExito: boolean;

  public mostrarMensajeFallido: boolean;

  public validoFormulario: boolean;

  public mensajeEjecucion: string;

  /**
   * Constructor del componente que permite inyectar dependencia
   * @param translate dependencia que permite manejar multilenguaje en el compoennte
   */
  constructor(public translate: TranslateService, private formBuilder: FormBuilder, private router: Router,
    private service: GestionarComicService, config: NgbModalConfig, private modalService: NgbModal,) {
    super(translate);

    config.backdrop = 'static';
    config.keyboard = true;

    this.gestionarComicForm = this.formBuilder.group({
      nombre: [null, Validators.required],
      editorial: [null, Validators.required],
      tematicaEnum: [null, Validators.required],
      coleccion: [null],
      numeroPaginas: [null, Validators.required],
      precio: [null, Validators.required],
      autores: [null],
      color: [true]
    });
  }

  /**
   * @description Evento angular que permite inicializar las variables del componente
   * @author Diego
   */
  ngOnInit(): void {
    // Atributo que representa un parametro de multilenguaje
    this.parametro = "Ejemplo parametro";
    this.listaComics = new Array<ComicDTO>();
    this.comicDto = new ComicDTO();
    this.mostrarMensajeExito = false;
    this.mostrarMensajeFallido = false;
    this.validoFormulario = false;
    //this.gestionarComicForm.disable();
    this.obtenerComics();
    this.obtenerUnComic();
  }

  private obtenerComics(): void {
    console.log("INICIA METODO obtenerComics()");
    this.service.obtenerComics().subscribe((comics: any) => {
      if (comics.status === "SUCCESS") {
        this.listaComics = comics.data;
        // console.log(data);
      }
    }, error => {
      console.log(error);
    });
    console.log("FINALIZA METODO obtenerComics()");
  }

  private obtenerUnComic(): void {
    this.service.obtenerComic(33).subscribe((comic: any) => {
      this.comicDto = comic.data;
    }, error => {
      console.log(error);
      this.mostrarMensajeFallido = true;
      this.mensajeEjecucion = error.error.data.errorMessage;
    });
  }

  /**
   * @description metodo que permite ejecutar la logica de la creacion de un comic
   * @author Diego
   */
  public crearComic(): void {
    // if(this.comicDto === null || this.comicDto.nombre === null || this.comicDto.nombre.trim() === "") {

    // }
    this.validoFormulario = true;
    if (this.gestionarComicForm.invalid) {
      return;
    }

    this.comicDto = this.gestionarComicForm.value;
    this.comicDto.estadoEnum = EstadoEnum.ACTIVO;
    //this.comicDto.fechaVenta = new Date();
    this.comicDto.cantidad = 10;

    this.service.crearComic(this.comicDto).subscribe(result => {
      if (result.status === "SUCCESS") {
        //this.listaComics.push(this.comicDto);
        // Metodo que permite limpiar los campos del formulario
        this.limpiarFormulario();
        this.mostrarMensajeExito = true;
        this.obtenerComics();
      }
    }, error => {
      console.log(error);
      this.mostrarMensajeFallido = true;
      this.mensajeEjecucion = error.error.data.errorMessage;
    })

    // this.comicDto.nombre = this.f.nombre.value;
    // this.comicDto.editorial = this.f.editorial.value;
    // this.comicDto.autores = this.f.autores.value;
    // this.comicDto.color = this.f.color.value;
  }

  private limpiarFormulario(): void {
    this.comicDto = new ComicDTO();
    this.gestionarComicForm.reset();
    this.f.color.setValue(true);
    this.validoFormulario = false;
    // this.f.nombre.setValue(null);
    // this.f.editorial.setValue(null);
    // this.f.tematicaEnum.setValue(null);
    // this.f.precio.setValue(null);
    // this.f.autores.setValue(null);
  }

  public cerrar(): void {
    this.mostrarMensajeExito = false;
  }

  public agregarValidacionColeccion(): void {
    let tematicaEnumRequiereColeccion = [TematicaEnum.AVENTURAS, TematicaEnum.HORROR];
    let tematicaSeleccionada = this.f.tematicaEnum.value;

    // this.f.coleccion.clearValidators();
    this.f.coleccion.enable();
    if (tematicaEnumRequiereColeccion.indexOf(tematicaSeleccionada) >= 0) {
      // this.f.coleccion.setValidators(Validators.required);
      this.f.coleccion.disable();
    }
    // this.f.coleccion.updateValueAndValidity();
  }

  get f() {
    return this.gestionarComicForm.controls;
  }

  // public consultarComic(comic : ComicDTO) : void {
  //   let comic = : ComicDTO = this.listaComics[0];
  //   this.gestionarComicForm.patchValue({
  //     nombre : comic.nombre,
  //     editorial : comic.editorial,
  //     tematicaEnum : comic.tematicaEnum,
  //     coleccion : comic.coleccion,
  //     numeroPaginas : comic.numeroPaginas,
  //     precio : comic.precio,
  //     autores : comic.autores,
  //     color : comic.color
  //   });
  // }

  public irConsultaComic(comic: ComicDTO): void {
    this.router.navigate(['consultar-comic', comic]);
  }

  public irComprarComic(comic: ComicDTO): void {
    this.router.navigate(['comprar-comic', comic]);
  }

  public abrirmodal(content): void {
    this.modalService.open(content).result.then((result: any) => {
      if (result) {
        console.log("ELIMINADO");
      }
    }, error => {
      console.log(error);
    });
  }

  public confirmarEliminacion(comic: any): void {
    if (confirm("Esta seguro de eliminar el comic?")) {
      console.log('Eliminar');
    }
  }

}

