import {Component, OnInit} from '@angular/core';
import {HobbyVoModel} from '../shared/domain/hobby-vo.model';
import {switchMap} from 'rxjs/operators';
import {ProfileDtoModel} from '../shared/domain/profile-dto.model';
import {AuthService, UserService} from '../service';
import {Router} from '@angular/router';
import {ProfileService} from '../service/profile.service';

@Component({
    selector: 'hobbify-profile-main',
    templateUrl: './profile-main.component.html',
    styleUrls: ['./profile-main.component.scss']
})
export class ProfileMainComponent implements OnInit {

    selectedIndex: number = 1;

    constructor() {}

    ngOnInit() {
    }

    onSidebarSelectionChange(index: number) {
        this.selectedIndex = index;
    }
}
