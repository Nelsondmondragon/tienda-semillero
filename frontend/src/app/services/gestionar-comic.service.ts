import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ComicDTO } from '../dto/comic-dto';

const back_end_url = "http://localhost:9091/"

@Injectable({
  providedIn: 'root'
})
export class GestionarComicService {

  constructor(private httpClient : HttpClient) { }

  public obtenerComics() : Observable<any> {
    return this.httpClient.get(back_end_url + 'tiendaComic/obtenerComics');
  }

  public crearComic(comicDTO : ComicDTO) : Observable<any> {
    //RequestBody POST PUT
    return this.httpClient.post<any>(back_end_url + 'tiendaComic/createComic', comicDTO);
  }

  public obtenerComic(idComic : number) : Observable<ComicDTO> {
    //JSON.stringify(idComic)
    //let comic : ComicDTO = new ComicDTO();
    //JSON.stringify(comic)
    let parametros = new HttpParams().set("idComic", idComic);
    // return this.httpClient.get<ComicDTO>(back_end_url + 'tiendaComic/obtenerComic/'+idComic, { params : parametros });
    return this.httpClient.get<ComicDTO>(back_end_url + 'tiendaComic/obtenerComic/', { params : parametros });
  }
}
