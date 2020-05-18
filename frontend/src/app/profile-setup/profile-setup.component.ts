import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {HobbyMetadataService} from '../service/hobby-metadata.service';
import {HobbyMetadataVoModel} from '../shared/domain/hobby-metadata-vo.model';
import {HobbyVoModel} from '../shared/domain/hobby-vo.model';
import {UserService} from '../service';
import {map, switchMap} from 'rxjs/operators';
import {ProfileDtoModel} from '../shared/domain/profile-dto.model';
import {ProfileService} from '../service/profile.service';
import {Observable, of} from 'rxjs';

@Component({
    selector: 'hobbify-profile-setup',
    templateUrl: './profile-setup.component.html',
    styleUrls: ['./profile-setup.component.scss']
})
export class ProfileSetupComponent implements OnInit {

    hobbyMetadata: HobbyMetadataVoModel;

    constructor(
        private hobbyMetadataService: HobbyMetadataService,
        private userService: UserService,
        private profileService: ProfileService,
        private router: Router
    ) {
    }

    ngOnInit() {
        this.hobbyMetadataService.getHobbyMetadata().subscribe(data => {
            this.hobbyMetadata = data;
        });

        this.userService.getCurrentUser().pipe(switchMap(
            user => this.profileService.getProfileByUserUuid(user.uuid)
        )).subscribe(profile => {
            if (profile) {
                this.router.navigate(['/home']);
            }
        });
    }

    submit(event: HobbyVoModel[]) {
        this.userService.getCurrentUser()
            .pipe(switchMap(user => {
                const profileDto = new ProfileDtoModel();
                profileDto.customUserUuid = user.uuid;
                profileDto.hobbies = event;


                return this.profileService.saveProfile(profileDto);
            })).subscribe(data => {
                this.profileService.setUserProfile(data);
                this.router.navigate(['/home']);
        });
    }
}
