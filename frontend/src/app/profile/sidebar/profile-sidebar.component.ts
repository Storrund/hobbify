import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {ProfileDtoModel} from '../../shared/domain/profile-dto.model';
import {AuthService} from '../../auth/auth.service';
import {ProfileService} from '../../service/profile.service';

@Component({
    selector: 'hobbify-profile-sidebar',
    templateUrl: './profile-sidebar.component.html',
    styleUrls: ['./profile-sidebar.component.scss']
})
export class ProfileSidebarComponent implements OnInit {

    profile: ProfileDtoModel;

    constructor(
        private profileService: ProfileService,
        private authService: AuthService,
        private router: Router
    ) {
    }

    ngOnInit() {
        this.profileService.getUserProfile().subscribe(profile => {
            this.profile = profile;
        });
    }

    home() {
        this.router.navigate(['/home']);
    }

    logout() {
        this.authService.logout().subscribe(res => {
            this.router.navigate(['/auth']);
        });
    }
}
