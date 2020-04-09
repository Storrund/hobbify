import {Component, OnDestroy, OnInit} from '@angular/core';
import {AuthService} from './auth.service';

@Component({
    selector: 'app-auth-component',
    templateUrl: './auth.component.html',
    styleUrls: ['./auth.component.scss']
})
export class AuthComponent implements OnInit {

    constructor(
        private authService: AuthService
    ) {}

    ngOnInit(): void {
        this.authService.logout().subscribe();
    }

}
