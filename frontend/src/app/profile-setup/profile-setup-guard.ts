import {ActivatedRouteSnapshot, CanActivate, CanDeactivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import {Injectable} from '@angular/core';
import {UserService} from '../service';
import {Observable, of} from 'rxjs';
import {ProfileService} from '../service/profile.service';

@Injectable()
export class ProfileSetupGuard implements CanActivate {

    constructor(private router: Router,
                private userService: UserService,
                private profileService: ProfileService) {
    }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot)
        : Observable<boolean|UrlTree>|Promise<boolean|UrlTree>|boolean|UrlTree {

        return this.checkProfile(route, state);
    }

    checkProfile(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> {
        return new Observable<boolean>(observer => {
            if (state.url.includes('/auth')) {
                observer.next(true);
            } else if (state.url.includes('/profile')) {
                this.userService.getCurrentUser().subscribe(user => {
                    if (user) {
                        this.profileService.getProfileByUserUuid(user.uuid).subscribe(profile => {
                            if (profile) {
                                this.router.navigate(['/home']);
                            }

                            observer.next(true);
                        });
                    }
                });
            } else {
                this.userService.getCurrentUser().subscribe(user => {
                    if (user) {
                        this.profileService.getProfileByUserUuid(user.uuid).subscribe(profile => {
                            if (profile) {
                                observer.next(true);
                            } else {
                                observer.next(false);
                            }
                        });
                    }
                });
            }
        });
    }
}
