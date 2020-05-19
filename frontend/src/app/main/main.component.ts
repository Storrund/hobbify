import {Component, OnInit} from '@angular/core';
import {AuthService, UserService} from '../service';
import {Router} from '@angular/router';
import {HobbyMetadataService} from '../service/hobby-metadata.service';
import {HobbyVoModel} from '../shared/domain/hobby-vo.model';

@Component({
    selector: 'hobbify-main',
    templateUrl: './main.component.html',
    styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {

    selectedHobbyFeed: HobbyVoModel;

    constructor() {}

    ngOnInit() {
    }


    selectHobbyFeed(event: HobbyVoModel) {
        this.selectedHobbyFeed = event;
    }
}
