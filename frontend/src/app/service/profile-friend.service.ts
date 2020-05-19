import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {ConfigService} from './config.service';
import {Observable} from 'rxjs';
import {HttpHeaders} from '@angular/common/http';
import {ProfileFriendVoModel} from '../shared/domain/profile-friend-vo.model';
import {ProfileFriendDtoModel} from '../shared/domain/profile-friend-dto.model';
import {ProfileVoModel} from '../shared/domain/profile-vo.model';

@Injectable({
    providedIn: 'root'
})
export class ProfileFriendService {

    constructor(private apiService: ApiService, private config: ConfigService) {
    }

    saveFriendRequest(profileFriendDtoModel: ProfileFriendDtoModel): Observable<ProfileFriendVoModel> {
        const headers = new HttpHeaders({
            Accept: 'application/json',
            'Content-Type': 'application/json'
        });

        return this.apiService.post(this.config.profile_friend_url, JSON.stringify(profileFriendDtoModel), headers);
    }

    accept(profileFriendUuid: string): Observable<ProfileFriendVoModel> {
        return this.apiService.post(this.config.profile_friend_url + '/' + profileFriendUuid, {});
    }

    getFriendsRequests(profileUuid: string, limit: number, offset: number): Observable<ProfileFriendVoModel[]> {
        return this.apiService.get(this.config.profile_friend_url + '/requests/' + profileUuid + '/' + limit + '/' + offset);
    }

    getFriends(profileUuid: string, limit: number, offset: number): Observable<ProfileVoModel[]> {
        return this.apiService.get(this.config.profile_friend_url + '/' + profileUuid + '/' + limit + '/' + offset);
    }
}
