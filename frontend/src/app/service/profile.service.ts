import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {ConfigService} from './config.service';
import {Observable, ReplaySubject} from 'rxjs';
import {HttpHeaders} from '@angular/common/http';
import {take} from 'rxjs/operators';
import {ProfileDtoModel} from '../shared/domain/profile-dto.model';
import {ProfileVoModel} from '../shared/domain/profile-vo.model';
import { isEqual } from 'lodash';

@Injectable({
    providedIn: 'root'
})
export class ProfileService {

    userProfile = new ProfileVoModel();

    private userProfileSubject: ReplaySubject<ProfileVoModel> = new ReplaySubject<ProfileVoModel>(1);

    constructor(private apiService: ApiService, private config: ConfigService) {
        this.userProfileSubject.next(this.userProfile);
    }

    getUserProfile(): Observable<ProfileVoModel> {
        return this.userProfileSubject.asObservable();
    }

    setUserProfile(profile: ProfileVoModel) {
        this.userProfileSubject.pipe(take(1)).subscribe(oldProfile => {
            if (!isEqual(oldProfile, profile)) {
                this.userProfileSubject.next(profile);
            }
        });

        this.userProfile = profile;
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

    findAllByName(profileUuid: string, name: string, limit: number, offset: number): Observable<ProfileVoModel[]> {
        return this.apiService.get(this.config.profile_url + '/search/' + profileUuid + '/' + name + '/' + limit + '/' + offset);
    }
}
