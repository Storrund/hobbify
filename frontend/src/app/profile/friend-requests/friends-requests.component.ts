import {Component, OnInit} from '@angular/core';
import {ProfileFriendService} from '../../service/profile-friend.service';
import {ProfileService} from '../../service/profile.service';
import {ProfileVoModel} from '../../shared/domain/profile-vo.model';
import {ProfileFriendVoModel} from '../../shared/domain/profile-friend-vo.model';

@Component({
    selector: 'hobbify-friends-requests',
    templateUrl: './friends-requests.component.html',
    styleUrls: ['./friends-requests.component.scss']
})
export class FriendsRequestsComponent implements OnInit {

    currentProfile: ProfileVoModel;
    friendRequestsResults: ProfileFriendVoModel[] = [];

    constructor(private profileFriendService: ProfileFriendService,
                private profileService: ProfileService) {}

    ngOnInit() {
        this.profileService.getUserProfile().subscribe(profile => {
            this.profileFriendService.getFriendsRequests(profile.uuid, 10, 0).subscribe(friendRequests => {
                this.friendRequestsResults = friendRequests;
            });
        });
    }

    onAccept(event: ProfileVoModel) {
        const profileAccepted: ProfileFriendVoModel = this.friendRequestsResults.find(item => item.firstProfile === event.uuid);

        if (profileAccepted) {
            this.profileFriendService.accept(profileAccepted.uuid).subscribe(value => {
                const index: number = this.friendRequestsResults.indexOf(profileAccepted);
                if (index !== -1) {
                    this.friendRequestsResults.splice(index, 1);
                }
            });
        }
    }
}
