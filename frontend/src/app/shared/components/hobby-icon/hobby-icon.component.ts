import {Component, Input, OnInit} from '@angular/core';

@Component({
    selector: 'hobbify-hobby-icon',
    templateUrl: './hobby-icon.component.html',
    styleUrls: ['./hobby-icon.component.scss']
})
export class HobbyIconComponent implements OnInit {

    @Input() iconTag: string;

    @Input() size: string;

    @Input() color: string;

    @Input() isSelected: boolean;

    constructor() {}

    ngOnInit() {
    }
}
