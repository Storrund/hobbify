import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {ConfigService} from './config.service';
import {Observable, of, ReplaySubject} from 'rxjs';
import {HobbyMetadataVoModel} from '../shared/domain/hobby-metadata-vo.model';
import {HttpHeaders} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {ProfileDtoModel} from '../shared/domain/profile-dto.model';
import {CustomUserModel} from '../shared/domain/auth/custom-user.model';
import {ProfileVoModel} from '../shared/domain/profile-vo.model';

@Injectable({
    providedIn: 'root'
})
export class ProfileService {


    private userProfileSubject: ReplaySubject<ProfileVoModel> = new ReplaySubject<ProfileVoModel>(1);

    constructor(private apiService: ApiService, private config: ConfigService) {}

    getUserProfile(): Observable<ProfileVoModel> {
        return this.userProfileSubject.asObservable();
    }

    setUserProfile(profile: ProfileVoModel) {
        this.userProfileSubject.next(profile);
    }

    saveProfile(profile: ProfileDtoModel): Observable<ProfileVoModel> {
        const headers = new HttpHeaders({
            Accept: 'application/json',
            'Content-Type': 'application/json'
        });

        return this.apiService.post(this.config.profile_url, JSON.stringify(profile), headers);
    }

    getProfileByUserUuid(userUuid: string): Observable<ProfileVoModel> {
        return this.apiService.get(this.config.profile_url + '/' + userUuid);
    }
}
