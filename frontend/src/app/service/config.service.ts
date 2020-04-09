import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  private _api_url = '/api';
  private _user_url = this._api_url + '/user';

  get refresh_token_url(): string {
    return this._api_url + '/refresh';
  }

  get login_url(): string {
    return this._api_url + '/login';
  }

  get logout_url(): string {
    return this._api_url + '/logout';
  }

  get change_password_url(): string {
    return this._api_url + '/changePassword';
  }


  get whoami_url(): string {
    return this._api_url + '/whoami';
  }

  get users_url(): string {
    return this._user_url + '/all';
  }

  get reset_credentials_url(): string {
    return this._user_url + '/reset-credentials';
  }

  get signup_url(): string {
    return this._api_url + '/signup';
  }

}
