import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { EstacionamientoComponent } from './estacionamiento/estacionamiento.component';
import { FormsModule } from '@angular/forms';
import { RegistroService } from './service/registro.service';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    EstacionamientoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [RegistroService],
  bootstrap: [AppComponent]
})
export class AppModule { }
