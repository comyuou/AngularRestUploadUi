import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { UserService } from './user.service';
import { DemoMaterialModule } from './material-module';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    CommonModule,
    NoopAnimationsModule,
    DemoMaterialModule
  ],
  providers: [UserService,HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }

