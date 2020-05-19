import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {AuthService} from '../../service';
import {Router} from '@angular/router';
import {ProfileService} from '../../service/profile.service';
import {ProfileDtoModel} from '../../shared/domain/profile-dto.model';
import {HobbyVoModel} from '../../shared/domain/hobby-vo.model';

@Component({
    selector: 'hobbify-sidebar',
    templateUrl: './sidebar.component.html',
    styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

    profile: ProfileDtoModel;

    @Output() selectedHobby = new EventEmitter();

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

    logout() {
        this.authService.logout().subscribe(res => {
            this.router.navigate(['/auth']);
        });
    }

    selectHobbyFeed(hobby: HobbyVoModel) {
        this.selectedHobby.emit(hobby);
    }

    onFindFriends() {

    }
}
