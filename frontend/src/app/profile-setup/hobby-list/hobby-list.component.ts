import {Component, EventEmitter, Input, Output} from '@angular/core';
import {HobbyMetadataVoModel} from '../../shared/domain/hobby-metadata-vo.model';
import {HobbyVoModel} from '../../shared/domain/hobby-vo.model';

@Component({
    selector: 'hobbify-hobby-list',
    templateUrl: './hobby-list.component.html',
    styleUrls: ['./hobby-list.component.scss']
})
export class HobbyListComponent {

    @Input() hobbyMetadata: HobbyMetadataVoModel;
    selectedHobbies: HobbyVoModel[] = [];

    @Output() submitSelected = new EventEmitter<HobbyVoModel[]>();

    constructor() {}

    select(hobby: HobbyVoModel) {
        if (this.selectedHobbies.find(item => item.uuid === hobby.uuid)) {
            const index = this.selectedHobbies.indexOf(hobby);
            this.selectedHobbies.splice(index, 1);
        } else {
            this.selectedHobbies.push(hobby);
        }
    }

    isSelected(hobby: HobbyVoModel): boolean {
        return !!this.selectedHobbies.find(item => item.uuid === hobby.uuid);
    }

    submit() {
        this.submitSelected.emit(this.selectedHobbies);
    }
}
