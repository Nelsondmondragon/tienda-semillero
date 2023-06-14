import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ComicDTO } from '../dto/comic-dto';

const back_end_url = "http://localhost:8080/"

@Injectable({
  providedIn: 'root'
})
export class GestionarComicService {

  constructor(private httpClient: HttpClient) { }

  public obtenerComics(): Observable<any> {
    return this.httpClient.get(back_end_url + 'tiendacomic');
  }

  public crearComic(comicDTO: ComicDTO): Observable<any> {
    //RequestBody POST PUT
    return this.httpClient.post<any>(back_end_url + 'tiendacomic', comicDTO);
  }

  public obtenerComic(idComic: number): Observable<ComicDTO> {
    //JSON.stringify(idComic)
    //let comic : ComicDTO = new ComicDTO();
    //JSON.stringify(comic)
    let parametros = new HttpParams().set("idComic", idComic);
    // return this.httpClient.get<ComicDTO>(back_end_url + 'tiendaComic/obtenerComic/'+idComic, { params : parametros });
    return this.httpClient.get<ComicDTO>(back_end_url + 'tiendacomic/', { params: parametros });
  }

  public comprarComic(idComic: number, cantidad: number): Observable<any> {
    return this.httpClient.get<any>(`${back_end_url}compra/${idComic}?cantidad=${cantidad}`);
  }

}
