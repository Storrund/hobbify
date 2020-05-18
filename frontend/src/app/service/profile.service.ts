import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {ConfigService} from './config.service';
import {Observable, of, ReplaySubject} from 'rxjs';
import {HobbyMetadataVoModel} from '../shared/domain/hobby-metadata-vo.model';
import {HttpHeaders} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {ProfileDtoModel} from '../shared/domain/profile-dto.model';
import {CustomUserModel} from '../shared/domain/auth/custom-user.model';

@Injectable({
    providedIn: 'root'
})
export class ProfileService {


    private userProfileSubject: ReplaySubject<ProfileDtoModel> = new ReplaySubject<ProfileDtoModel>(1);

    constructor(private apiService: ApiService, private config: ConfigService) {}

    getUserProfile(): Observable<ProfileDtoModel> {
        return this.userProfileSubject.asObservable();
    }

    setUserProfile(profile: ProfileDtoModel) {
        this.userProfileSubject.next(profile);
    }

    saveProfile(profile: ProfileDtoModel): Observable<ProfileDtoModel> {
        const headers = new HttpHeaders({
            Accept: 'application/json',
            'Content-Type': 'application/json'
        });

        return this.apiService.post(this.config.profile_url, JSON.stringify(profile), headers);
    }

    getProfileByUserUuid(userUuid: string): Observable<ProfileDtoModel> {
        return this.apiService.get(this.config.profile_url + '/' + userUuid);
    }
}
