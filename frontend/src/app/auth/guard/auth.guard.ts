import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import {UserService} from '../../service';
import {Observable, of} from 'rxjs';
import {difference} from 'lodash';
import {AuthorityModel} from '../../shared/domain/authority.model';

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(private router: Router, private userService: UserService) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot)
      : Observable<boolean|UrlTree>|Promise<boolean|UrlTree>|boolean|UrlTree {

    return this.checkUser(route, state);
  }

  checkUser(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> {
    const routeAuthorities: AuthorityModel[] = route.data.authorities;

    if (!routeAuthorities) {
      return of(true);
    } else {
      this.userService.getMyInfo().subscribe(user => {
        if (user) {
          const userAuthorities = user.authorities.map(item => item.authority);
          console.log(difference(routeAuthorities, userAuthorities).length);
          if (difference(routeAuthorities, userAuthorities).length !== 0) {
            this.router.navigate(['/403']);
            return of(false);
          }
        } else {
          this.router.navigate(['/auth'], {queryParams: {returnUrl: state.url}});
          return of(false);
        }
      }, error => {
        // this.router.navigate(['/auth'], {queryParams: {returnUrl: state.url}});
        // return of(false);
      });
    }

    return of(true);
  }
}
