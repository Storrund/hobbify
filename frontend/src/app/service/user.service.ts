import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {ConfigService} from './config.service';
import {map} from 'rxjs/operators';
import {Observable, of, ReplaySubject} from 'rxjs';
import {CustomUserModel} from '../shared/domain/custom-user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  currentUser;

  private currentUser1: ReplaySubject<CustomUserModel> = new ReplaySubject<CustomUserModel>(1);

  constructor(private apiService: ApiService, private config: ConfigService) {
  }

  getCurrentUser(): Observable<CustomUserModel> {
    return this.currentUser1.asObservable();
  }

  setCurrentUser(user: CustomUserModel) {
    this.currentUser1.next(user);
    this.currentUser = user;
  }

  initUser() {
    const promise = this.apiService.get(this.config.refresh_token_url).toPromise()
      .then(res => {
        if (res.access_token !== null) {
          return this.getMyInfo().toPromise()
            .then(user => {
              this.currentUser = user;
              this.currentUser1.next(user);
            });
        }
      })
      .catch(() => null);
    return promise;
  }

  resetCredentials() {
    return this.apiService.get(this.config.reset_credentials_url);
  }

  getMyInfo(): Observable<CustomUserModel> {
    return this.apiService.get(this.config.whoami_url);
  }

  getAll() {
    return this.apiService.get(this.config.users_url);
  }

}