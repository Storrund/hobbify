import {Component, OnInit} from '@angular/core';
import {AuthService, UserService} from '../service';
import {Router} from '@angular/router';
import {HobbyMetadataService} from '../service/hobby-metadata.service';

@Component({
    selector: 'hobbify-main',
    templateUrl: './main.component.html',
    styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {

    constructor(
        private userService: UserService,
        private authService: AuthService,
        private hobbyMetadataService: HobbyMetadataService,
        private router: Router
    ) {
    }

    ngOnInit() {
    }
}
