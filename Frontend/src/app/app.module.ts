import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { EstacionamientoComponent } from './estacionamiento/estacionamiento.component';
import { FormsModule } from '@angular/forms';
import { RegistroService } from './service/registro.service';

@NgModule({
  declarations: [
    AppComponent,
    EstacionamientoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
  ],
  providers: [RegistroService],
  bootstrap: [AppComponent]
})
export class AppModule { }
