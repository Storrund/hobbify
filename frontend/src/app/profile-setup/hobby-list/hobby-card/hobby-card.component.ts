import {Component, Input, OnInit} from '@angular/core';
import {HobbyVoModel} from '../../../shared/domain/hobby-vo.model';

@Component({
    selector: 'hobbify-hobby-card',
    templateUrl: './hobby-card.component.html',
    styleUrls: ['./hobby-card.component.scss']
})
export class HobbyCardComponent {

    @Input() hobby: HobbyVoModel;

    @Input() isSelected: boolean;

    @Input() color: string;

    constructor() {}

}
