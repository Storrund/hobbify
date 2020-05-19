import {Component, Input, OnInit} from '@angular/core';
import {ProfileVoModel} from '../../domain/profile-vo.model';
import {ProfileFriendDtoModel} from '../../domain/profile-friend-dto.model';
import {ProfileFriendService} from '../../../service/profile-friend.service';

@Component({
    selector: 'hobbify-profile',
    templateUrl: './profile.component.html',
    styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

    @Input() userProfile: ProfileVoModel;
    @Input() currentProfile: ProfileVoModel;

    constructor(private profileFriendService: ProfileFriendService) {}

    ngOnInit() {
    }

    addFriend() {
        const profileFriendDto: ProfileFriendDtoModel = new ProfileFriendDtoModel();
        profileFriendDto.firstProfileUuid = this.currentProfile.uuid;
        profileFriendDto.secondProfileUuid = this.userProfile.uuid;

        this.profileFriendService.saveFriendRequest(profileFriendDto).subscribe();
    }
}
