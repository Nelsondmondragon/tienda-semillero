import { Component, OnInit } from "@angular/core";
import { ComicDTO } from "../../../dto/comic-dto";

@Component({
  selector: "app-crear-persona",
  templateUrl: "./crear-persona.component.html",
  styleUrls: ["./crear-persona.component.scss"],
})
export class CrearPersonaComponent implements OnInit {
  public nombreInstructor: string;

  public comicDTO: any;

  public comicDTO2: any;

  public comis: Array<any>;

  public comicDTO3: ComicDTO;

  public objetoImagen: any;

  public labelImagen: any = "INGRESE PATH IMAGEN";

  public opcion: string;

  constructor() {}

  ngAfterViewInit(): void {}

  ngOnInit(): void {
    let edad: number = 21;
    edad = 12 + 1;
    //totalEdad = 0;
    if (true) {
      let totalEdad = 0;
      edad += 12;
    }

    this.nombreInstructor = "Diego Fernando Alvarez Silva";
    this.comicDTO = {
      nombre: "Batman",
      precio: 1900,
      autores: "Diego",
      fechaVenta: new Date(),
      color: true,
    };

    this.comicDTO2 = {
      nombre: "Spiderman",
      precio: 2900,
      autores: "Diego",
      fechaVenta: new Date(),
      color: true,
    };

    this.comis = new Array<any>();

    this.comicDTO3 = new ComicDTO();
    this.comicDTO3.nombre = "Spiderman";
    this.comicDTO3.precio = 2900;
    this.comicDTO3.autores = "Diego";
    this.comicDTO3.fechaVenta = new Date();
    this.comicDTO3.color = true;

    delete this.comicDTO.color;
    this.comicDTO.tematicaEnum = "HORROR";

    this.comis.push(this.comicDTO);
    this.comis.push(this.comicDTO2);
    this.comis.push(this.comicDTO3);

    this.contruirImagen();

    for (let i = 0; i < this.comis.length; i++) {
      const element = this.comis[i];
      console.log(JSON.stringify(element));
    }

    this.comis.forEach((data: any, index) => {
      console.log("indice: " + index + JSON.stringify(data));
    });
    //[0]
    this.comis.splice(1, 2);
    console.log("RESULTADO FINAL: " + JSON.stringify(this.comis));

    if (this.comicDTO.tematicaEnum === "HORROR") {
      delete this.comicDTO.nombre;
    } else if (this.comicDTO.tematicaEnum === "FANTASIA") {
      this.comicDTO.urlImagen = "dsfasdfasdf";
    } else {
    }
  }

  private contruirImagen(): void {
    this.objetoImagen = {
      path: "https://cdn.atomix.vg/wp-content/uploads/2020/01/spaw.jpg",
      width: 300,
      height: 400,
    };
  }

  public imprimirPathImage(path: string): void {
    alert("Path imagen: " + path);
  }

  public seleccionarImagen(opcion: string): string {
    switch (opcion) {
      case "1":
        this.objetoImagen.path =
          "https://cdn.atomix.vg/wp-content/uploads/2020/01/spaw.jpg";
        this.objetoImagen.width = 100;
        this.objetoImagen.height = 700;
        break;

      case "2":
        this.objetoImagen.path =
          "https://www.latercera.com/resizer/2OyP9tCVpqBM83CDSFT9ePdp5lY=/arc-anglerfish-arc2-prod-copesa/public/YTXICGCO5BBVXOMOEEGQKEN4U4.jpg";
        this.objetoImagen.width = 300;
        this.objetoImagen.height = 500;
        break;

      case "3":
        this.objetoImagen.path =
          "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTMoOx7oZ06Ax6G20r7KkxbAOduGNB2ZfpQvg&usqp=CAU";
        this.objetoImagen.width = 600;
        this.objetoImagen.height = 100;
        break;

      case "4":
        this.objetoImagen.path =
          "https://i.ytimg.com/vi/eZuI8jB1m7A/maxresdefault.jpg";
        this.objetoImagen.width = 700;
        this.objetoImagen.height = 700;
        break;

      default:
        this.objetoImagen.path =
          "https://img2.rtve.es/i/?w=1600&i=1395681002931.jpg";
        this.objetoImagen.width = 800;
        this.objetoImagen.height = 100;
        break;
    }

    return null;
  }
}
