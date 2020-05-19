import {Component, OnInit} from '@angular/core';
import {HobbyVoModel} from '../shared/domain/hobby-vo.model';

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
