import {NgModule} from '@angular/core';
import {Route, RouterModule, Routes} from '@angular/router';
import {AdminComponent} from './admin';
import {NotFoundComponent} from './not-found';
import {ChangePasswordComponent} from './change-password';
import {ForbiddenComponent} from './forbidden';
import {AuthGuard} from './auth/guard';
import {AuthComponent} from './auth';
import {MainComponent} from './main/main.component';
import {ProfileSetupComponent} from './profile-setup/profile-setup.component';
import {ProfileSetupGuard} from './profile-setup/profile-setup-guard';
import {CompositeRouteGuard} from './shared/composite-route-guard';
import {AppComponent} from './app.component';

export const routes: Route[] = [
  {
    path: '',
    data: {
      routeGuards: [AuthGuard, ProfileSetupGuard]
    },
    canActivateChild: [CompositeRouteGuard],
    children: [
      {
        path: '',
        pathMatch: 'full',
        redirectTo: 'home'
      },
      {
        path: 'home',
        data: { authorities: ['ROLE_USER'] },
        component: MainComponent,
      },
      {
        path: 'profile',
        component: ProfileSetupComponent,
      },
      {
        path: 'auth',
        component: AuthComponent,
      },
      {
        path: 'change-password',
        component: ChangePasswordComponent,
        data: { authorities: ['ROLE_USER', 'ROLE_ADMIN'] },
      },
      {
        path: 'admin',
        component: AdminComponent,
        data: { authorities: ['ROLE_ADMIN'] },
      },
    ]
  },
  {
    path: '404',
    component: NotFoundComponent
  },
  {
    path: '403',
    component: ForbiddenComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule {
}
