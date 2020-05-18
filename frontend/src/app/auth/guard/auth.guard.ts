import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import {UserService} from '../../service';
import {Observable, of} from 'rxjs';
import {difference} from 'lodash';
import {AuthorityModel} from '../../shared/domain/auth/authority.model';
import {ProfileService} from '../../service/profile.service';

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(private router: Router, private userService: UserService, private profileService: ProfileService) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot)
      : Observable<boolean|UrlTree>|Promise<boolean|UrlTree>|boolean|UrlTree {

    return this.checkUser(route, state);
  }

  checkUser(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> {
    return new Observable<boolean>(observer => {
      if (state.url.includes('/auth')) {
        observer.next(true);
      } else {
        const routeAuthorities: AuthorityModel[] = route.data.authorities;

        this.userService.getMyInfo().subscribe(user => {
          this.profileService.getProfileByUserUuid(user.uuid).subscribe(profile => {
            this.profileService.setUserProfile(profile);
          })

          this.userService.setCurrentUser(user);
          if (!routeAuthorities) {
            observer.next(true);
          } else if (user) {
            this.profileService.getProfileByUserUuid(user.uuid).subscribe(profile => {
              this.profileService.setUserProfile(profile);
            })
            this.userService.setCurrentUser(user);
            const userAuthorities = user.authorities.map(item => item.authority);
            if (difference(routeAuthorities, userAuthorities).length !== 0) {
              this.router.navigate(['/403']);
              observer.next(false);
            } else {
              observer.next(true);
            }
          } else {
            this.router.navigate(['/auth'], {queryParams: {returnUrl: state.url}});
            observer.next(false);
          }
        }, error => {
          this.router.navigate(['/auth'], {queryParams: {returnUrl: state.url}});
          observer.next(false);
        });
      }
    });
  }
}
