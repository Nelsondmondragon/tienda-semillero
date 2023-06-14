import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminLayoutRoutes } from './admin-layout.routing';
import { UserProfileComponent } from '../../user-profile/user-profile.component';
import { TableListComponent } from '../../table-list/table-list.component';
import { TypographyComponent } from '../../typography/typography.component';
import { HomeComponent } from '../../home/home.component';
import { NotificationsComponent } from '../../notifications/notifications.component';
import { ChartsModule } from 'ng2-charts';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ToastrModule } from 'ngx-toastr';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CrearPersonaComponent } from './crear-persona/crear-persona.component';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { GestionarComicComponent } from './gestionar-comic/gestionar-comic.component';
import { ConsultarComicComponent } from './consultar-comic/consultar-comic.component';
import { CompraComicComponent } from './compra-comic/compra-comic.component';
import { ModalComponent } from './modal/modal.component';
import { ModalSuccessComponent } from './modal-success/modal-success.component';

export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http);
}

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    ChartsModule,
    NgbModule,
    ReactiveFormsModule,
    HttpClientModule,    
    ToastrModule.forRoot(),
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
          useFactory: HttpLoaderFactory,
          deps: [HttpClient]
      }
    })
  ],
  declarations: [
    UserProfileComponent,
    TableListComponent,
    TypographyComponent,
    HomeComponent,
    NotificationsComponent,
    CrearPersonaComponent,
    GestionarComicComponent,
    ConsultarComicComponent,
    CompraComicComponent,
    ModalComponent,
    ModalSuccessComponent, 
  ]
})

export class AdminLayoutModule {}
