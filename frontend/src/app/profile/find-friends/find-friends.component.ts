import {Component, OnInit} from '@angular/core';
import {ProfileService} from '../../service/profile.service';
import {ProfileVoModel} from '../../shared/domain/profile-vo.model';

@Component({
    selector: 'hobbify-find-friends',
    templateUrl: './find-friends.component.html',
    styleUrls: ['./find-friends.component.scss']
})
export class FindFriendsComponent implements OnInit {

    name: string;

    profileSearchResult: ProfileVoModel[] = [];
    currentProfile: ProfileVoModel;

    loadCount: number = 0;

    constructor(private profileService: ProfileService) {}

    ngOnInit() {
        this.profileService.getUserProfile().subscribe(profile => {
            this.currentProfile = profile;
        });
    }

    onSearchChange(searchValue: string): void {
        if(searchValue.length === 0) {
            this.profileSearchResult = [];
        }

        if (searchValue.length > 2) {
            this.profileService.findAllByName(searchValue, 10, 0).subscribe(profiles => {
                this.profileSearchResult = profiles;
                this.loadCount = 1;
            });
        }
    }

    onLoadProfiles() {
        this.profileService.findAllByName(this.name, 10, this.profileSearchResult.length).subscribe(profiles => {
            this.profileSearchResult = [...this.profileSearchResult, ...profiles];
            this.loadCount++;
        });
    }

    isMore(): boolean {
        return this.profileSearchResult.length >= this.loadCount * 10 && this.profileSearchResult.length > 0;
    }
}
