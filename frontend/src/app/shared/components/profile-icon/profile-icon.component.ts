import {Component, Input, OnInit} from '@angular/core';

@Component({
    selector: 'hobbify-profile-icon',
    templateUrl: './profile-icon.component.html',
    styleUrls: ['./profile-icon.component.scss']
})
export class ProfileIconComponent implements OnInit {

    @Input() firstName: string;

    @Input() lastName: string;

    private _size: number;
    @Input() set size(value: number) {
        this._size = value;
        this.sizeDimensions = this._size * 3.43;
    }

    get size() {
        return this._size;
    }

    @Input() color: string;

    sizeDimensions: number;

    constructor() {}

    ngOnInit() {
    }

    getContent(): string {
        return this.firstName.charAt(0) + this.lastName.charAt(0);
    }
}
