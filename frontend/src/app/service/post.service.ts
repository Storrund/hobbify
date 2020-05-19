import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {ConfigService} from './config.service';
import {Observable, of, ReplaySubject} from 'rxjs';
import {HobbyMetadataVoModel} from '../shared/domain/hobby-metadata-vo.model';
import {HttpHeaders} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {ProfileDtoModel} from '../shared/domain/profile-dto.model';
import {CustomUserModel} from '../shared/domain/auth/custom-user.model';
import {PostVoModel} from '../shared/domain/post-vo.model';
import {PostDtoModel} from '../shared/domain/post-dto.model';

@Injectable({
    providedIn: 'root'
})
export class PostService {


    constructor(private apiService: ApiService, private config: ConfigService) {}

    savePost(post: PostDtoModel): Observable<PostVoModel> {
        const headers = new HttpHeaders({
            Accept: 'application/json',
            'Content-Type': 'application/json'
        });

        return this.apiService.post(this.config.post_url, JSON.stringify(post), headers);
    }

    getProfileByUserUuid(hobbyUuid: string, profileUuid): Observable<PostVoModel> {
        return this.apiService.get(this.config.post_url + '/' + hobbyUuid + '/' + profileUuid);
    }
}
