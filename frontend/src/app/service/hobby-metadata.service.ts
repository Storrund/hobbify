import {Injectable} from '@angular/core';
import {ApiService} from './api.service';
import {ConfigService} from './config.service';
import {Observable} from 'rxjs';
import {HobbyMetadataVoModel} from '../shared/domain/hobby-metadata-vo.model';

@Injectable({
    providedIn: 'root'
})
export class HobbyMetadataService {

    constructor(private apiService: ApiService, private config: ConfigService) {
    }

    getHobbyMetadata(): Observable<HobbyMetadataVoModel> {
        return this.apiService.get(this.config.hobby_metadata_url);
    }
}
