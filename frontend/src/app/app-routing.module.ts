import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AdminComponent} from './admin';
import {NotFoundComponent} from './not-found';
import {ChangePasswordComponent} from './change-password';
import {ForbiddenComponent} from './forbidden';
import {AuthGuard} from './auth/guard';
import {AuthComponent} from './auth';
import {MainComponent} from './main/main.component';

export const routes: Routes = [
  {
    path: '',
    component: MainComponent,
    data: { authorities: ['ROLE_USER'] },
    canActivate: [AuthGuard],
    pathMatch: 'full'
  },
  {
    path: 'auth',
    component: AuthComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'change-password',
    component: ChangePasswordComponent,
    data: { authorities: ['ROLE_USER', 'ROLE_ADMIN'] },
    canActivate: [AuthGuard]
  },
  {
    path: 'admin',
    component: AdminComponent,
    data: { authorities: ['ROLE_ADMIN'] },
    canActivate: [AuthGuard]
  },
  {
    path: '404',
    component: NotFoundComponent
  },
  {
    path: '403',
    component: ForbiddenComponent
  },
  {
    path: '**',
    redirectTo: '/404'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule {
}
