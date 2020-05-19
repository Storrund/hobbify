import {BrowserModule} from '@angular/platform-browser';
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule, HttpClientXsrfModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FlexLayoutModule} from '@angular/flex-layout';
import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {NotFoundComponent} from './not-found';

import {ApiService, AuthService, ConfigService, UserService} from './service';
import {ChangePasswordComponent} from './change-password';
import {ForbiddenComponent} from './forbidden';
import {AdminComponent} from './admin';
import {AuthGuard} from './auth/guard';
import {AuthComponent, LoginComponent, SignupComponent} from './auth';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import {MessagesModule} from 'primeng/messages';
import {MessageModule} from 'primeng/message';
import {MainComponent} from './main/main.component';
import {HobbyMetadataService} from './service/hobby-metadata.service';
import {ProfileSetupComponent} from './profile-setup/profile-setup.component';
import {HobbyListComponent} from './profile-setup/hobby-list/hobby-list.component';
import {HobbyIconComponent} from './shared/components/hobby-icon/hobby-icon.component';
import {HobbyCardComponent} from './profile-setup/hobby-list/hobby-card/hobby-card.component';
import {ProfileService} from './service/profile.service';
import {XhrInterceptor} from './auth/xhr-interceptor';
import {CanDeactivate} from '@angular/router/src/utils/preactivation';
import {ProfileSetupGuard} from './profile-setup/profile-setup-guard';
import {CompositeRouteGuard} from './shared/composite-route-guard';
import {SidebarComponent} from './main/sidebar/sidebar.component';
import {HobbyFeedComponent} from './main/hobby-feed/hobby-feed.component';
import {ProfileIconComponent} from './shared/components/profile-icon/profile-icon.component';
import {HobbifyDatePipe} from './shared/components/date-pipe/hobbify-date.pipe';

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
      MainComponent,
      ProfileSetupComponent,
      HobbyListComponent,
      HobbyIconComponent,
      HobbyCardComponent,
      SidebarComponent,
      HobbyFeedComponent,
      ProfileIconComponent,
      HobbifyDatePipe
  ],
  imports: [
      BrowserAnimationsModule,
      BrowserModule,
      HttpClientModule,
      HttpClientXsrfModule.withOptions({
          cookieName: 'XSRF-TOKEN',
          headerName: 'X-XSRF-TOKEN',
      }),
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
      ConfigService,
      HobbyMetadataService,
      ProfileService,
      ProfileSetupGuard,
      CompositeRouteGuard,
      { provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true }
  ],
  bootstrap: [AppComponent],
})
export class AppModule {
}
