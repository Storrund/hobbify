import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
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

    @Input() isRequest: boolean = false;

    @Output() acceptFriendRequest = new EventEmitter();
    @Output() sendFriendRequest = new EventEmitter();

    constructor(private profileFriendService: ProfileFriendService) {}

    ngOnInit() {
    }

    addFriend() {
        this.sendFriendRequest.emit(this.userProfile);
    }

    accept() {
        this.acceptFriendRequest.emit(this.userProfile);
    }
}
