import {ActivatedRouteSnapshot, CanActivate, CanActivateChild, Router, RouterStateSnapshot} from '@angular/router';
import {Injectable, Injector} from '@angular/core';
import {Observable, of} from 'rxjs';
import {flatMap} from 'rxjs/operators';

@Injectable()
export class CompositeRouteGuard implements CanActivateChild {

    constructor(  protected router: Router,
                  protected injector: Injector ) {
    }

    canActivateChild( route: ActivatedRouteSnapshot, state: RouterStateSnapshot ): Observable<boolean> {
        let compositeCanActivateObservable: Observable<boolean> = of(true);

        const routeGuards = route.parent.data.routeGuards;

        if (routeGuards) {
            for( let i = 0; i < routeGuards.length; i++ ) {
                let routeGuard = this.injector.get(routeGuards[i]);
                let canActivateObservable: Observable<boolean> = routeGuard.canActivate(route, state);
                compositeCanActivateObservable = compositeCanActivateObservable.pipe(flatMap( (bool) => {
                    if (!bool) {
                        return of(false);
                    } else {
                        return canActivateObservable;
                    }
                }));
            }
        }

        return compositeCanActivateObservable;
    }
}
