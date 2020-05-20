import {Component, Input, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {HobbyVoModel} from '../shared/domain/hobby-vo.model';
import {AuthService, UserService} from '../service';
import {switchMap, take} from 'rxjs/operators';
import {ProfileDtoModel} from '../shared/domain/profile-dto.model';
import {ProfileService} from '../service/profile.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ProfileUpdateDtoModel} from '../shared/domain/profile-update-dto.model';

@Component({
    selector: 'hobbify-profile-setup',
    templateUrl: './profile-setup.component.html',
    styleUrls: ['./profile-setup.component.scss']
})
export class ProfileSetupComponent implements OnInit {

    formGroup: FormGroup;

    @Input() edit: boolean = false;

    constructor(
        private userService: UserService,
        private profileService: ProfileService,
        private router: Router,
        private formBuilder: FormBuilder,
        private authService: AuthService
    ) {
    }

    ngOnInit() {
        if (!this.edit) {
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
        } else {
            this.profileService.getUserProfile().subscribe(profile => {
                this.formGroup = this.formBuilder.group({
                    firstName: [profile.firstName, Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(64)])],
                    lastName: [profile.lastName, Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(64)])],
                    description: [profile.description, Validators.compose([Validators.required])],
                });
            });
        }
    }

    submit(event: HobbyVoModel[]) {
        if (!this.edit) {
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
        } else {
            this.profileService.getUserProfile()
                .pipe(take(1), switchMap(user => {
                    const profileDto = new ProfileUpdateDtoModel();
                    profileDto.uuid = user.uuid;
                    profileDto.hobbies = event;
                    profileDto.firstName = this.formGroup.controls['firstName'].value;
                    profileDto.lastName = this.formGroup.controls['lastName'].value;
                    profileDto.description = this.formGroup.controls['description'].value;

                    return this.profileService.updateProfile(profileDto);
                })).subscribe(data => {
                this.authService.logout()
                this.router.navigate(['/auth']);
            });
        }
    }
}
