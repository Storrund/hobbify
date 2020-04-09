import {Component, OnInit} from '@angular/core';
import {AuthService, UserService} from '../service';
import {Router} from '@angular/router';

@Component({
    selector: 'app-main',
    templateUrl: './main.component.html',
    styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit{

    constructor(
        private userService: UserService,
        private authService: AuthService,
        private router: Router
    ) {
    }

    ngOnInit() {
    }

    hasSignedIn() {
        return !!this.userService.currentUser;
    }

    userName() {
        const user = this.userService.currentUser;
        return user.firstname + ' ' + user.lastname;
    }

    logout() {
        this.authService.logout().subscribe(res => {
            this.router.navigate(['/auth']);
        });
    }
}
