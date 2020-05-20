import {HobbyVoModel} from './hobby-vo.model';

export class ProfileUpdateDtoModel {

    uuid: string;

    firstName: string;

    lastName: string;

    hobbies: HobbyVoModel[];

    description: string;
}
