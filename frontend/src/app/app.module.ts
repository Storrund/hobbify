import {BrowserModule} from '@angular/platform-browser';
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FlexLayoutModule} from '@angular/flex-layout';
import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {NotFoundComponent} from './not-found';

import {ApiService, AuthService, ConfigService, UserService} from './service';
import {ChangePasswordComponent} from './change-password/change-password.component';
import {ForbiddenComponent} from './forbidden/forbidden.component';
import {AdminComponent} from './admin/admin.component';
import {AuthGuard} from './auth/guard';
import {AuthComponent, LoginComponent, SignupComponent} from './auth';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import {MessagesModule} from 'primeng/messages';
import {MessageModule} from 'primeng/message';
import {MainComponent} from './main/main.component';

@NgModule({
  declarations: [
      AppComponent,
      LoginComponent,
      NotFoundComponent,
      ChangePasswordComponent,
      ForbiddenComponent,
      AdminComponent,
      SignupComponent,
      AuthComponent,
      MainComponent
  ],
  imports: [
      BrowserAnimationsModule,
      BrowserModule,
      HttpClientModule,
      AppRoutingModule,
      FormsModule,
      ReactiveFormsModule,
      FlexLayoutModule,
      InputTextModule,
      ButtonModule,
      MessageModule,
      MessagesModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  providers: [
      AuthGuard,
      AuthService,
      ApiService,
      UserService,
      ConfigService
  ],
  bootstrap: [AppComponent],
})
export class AppModule {
}
