import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {HobbyMetadataVoModel} from '../../shared/domain/hobby-metadata-vo.model';
import {HobbyVoModel} from '../../shared/domain/hobby-vo.model';
import {HobbyMetadataService} from '../../service/hobby-metadata.service';
import {ProfileService} from '../../service/profile.service';
import { FormGroup } from '@angular/forms';

@Component({
    selector: 'hobbify-hobby-list',
    templateUrl: './hobby-list.component.html',
    styleUrls: ['./hobby-list.component.scss']
})
export class HobbyListComponent implements OnInit{

    hobbyMetadata: HobbyMetadataVoModel;
    selectedHobbies: HobbyVoModel[] = [];

    @Input() form: FormGroup;

    @Output() submitSelected = new EventEmitter<HobbyVoModel[]>();
    @Input() edit: boolean = false;

    constructor(private hobbyMetadataService: HobbyMetadataService,
                private profileService: ProfileService) {}

    ngOnInit() {
        this.hobbyMetadataService.getHobbyMetadata().subscribe(data => {
            this.hobbyMetadata = data;
            if (this.edit) {
                this.profileService.getUserProfile().subscribe(profile => {
                    for(let category of this.hobbyMetadata.hobbyCategories){
                        for(let hobby of this.hobbyMetadata.hobbies[category.uuid]){
                            let foundItem = profile.hobbies.find(item => item.uuid === hobby.uuid);
                            if (foundItem) {
                                this.selectedHobbies.push(foundItem);
                            }
                        }
                    }
                });
            }
        });
    }

    select(hobby: HobbyVoModel) {
        if (this.selectedHobbies.find(item => item.uuid === hobby.uuid)) {
            const index = this.selectedHobbies.findIndex(item => item.uuid === hobby.uuid);
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
