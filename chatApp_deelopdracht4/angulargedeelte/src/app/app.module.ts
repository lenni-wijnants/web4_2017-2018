import { NgModule }         from '@angular/core';
import { BrowserModule }    from '@angular/platform-browser';
import { HttpModule }       from '@angular/http';
import { FormsModule }      from '@angular/forms';

import { AppComponent }     from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { UsersComponent }  from './user.component';
import { UserService }      from './user.service';

@NgModule({
  imports: [
    BrowserModule,
      FormsModule,
      AppRoutingModule,
      HttpModule
  ],
  declarations: [
    AppComponent,
      UsersComponent
  ],
  providers: [ UserService ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
