import {Component, Input, OnInit} from '@angular/core';

@Component({
    selector: 'hobbify-hobby-icon',
    templateUrl: './hobby-icon.component.html',
    styleUrls: ['./hobby-icon.component.scss']
})
export class HobbyIconComponent implements OnInit {

    @Input() iconTag: string;

    private _size: number;
    @Input() set size(value: number) {
        this._size = value;
        this.sizeDimensions = this._size * 3.43;
        this.fontSize = this._size * 1.4;
    }

    get size() {
        return this._size;
    }

    @Input() color: string;

    @Input() isSelected: boolean;

    @Input() defaultColor: string = 'black';

    @Input() borderColor: string = 'black';

    @Input() backgroundColor: string = 'white';

    sizeDimensions: number;
    fontSize: number;

    constructor() {}

    ngOnInit() {
    }
}
