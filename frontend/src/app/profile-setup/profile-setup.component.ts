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
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
    selector: 'hobbify-profile-setup',
    templateUrl: './profile-setup.component.html',
    styleUrls: ['./profile-setup.component.scss']
})
export class ProfileSetupComponent implements OnInit {

    hobbyMetadata: HobbyMetadataVoModel;

    formGroup: FormGroup;
    description: string;

    constructor(
        private hobbyMetadataService: HobbyMetadataService,
        private userService: UserService,
        private profileService: ProfileService,
        private router: Router,
        private formBuilder: FormBuilder
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

        this.formGroup = this.formBuilder.group({
            firstName: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(64)])],
            lastName: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(64)])],
            description: ['', Validators.compose([Validators.required])],
        });
    }

    submit(event: HobbyVoModel[]) {
        this.userService.getCurrentUser()
            .pipe(switchMap(user => {
                const profileDto = new ProfileDtoModel();
                profileDto.customUserUuid = user.uuid;
                profileDto.hobbies = event;
                profileDto.firstName = this.formGroup.controls['firstName'].value;
                profileDto.lastName = this.formGroup.controls['lastName'].value;
                profileDto.description = this.formGroup.controls['description'].value;

                return this.profileService.saveProfile(profileDto);
            })).subscribe(data => {
                this.profileService.setUserProfile(data);
                this.router.navigate(['/home']);
        });
    }
}
