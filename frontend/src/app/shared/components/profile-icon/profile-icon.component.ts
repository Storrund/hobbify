import {Component, Input, OnInit} from '@angular/core';

@Component({
    selector: 'hobbify-profile-icon',
    templateUrl: './profile-icon.component.html',
    styleUrls: ['./profile-icon.component.scss']
})
export class ProfileIconComponent implements OnInit {

    @Input() firstName: string;

    @Input() lastName: string;

    @Input() size: string;

    @Input() color: string;

    constructor() {}

    ngOnInit() {
    }

    getContent(): string{
        return this.firstName.charAt(0) + this.lastName.charAt(0);
    }
}
