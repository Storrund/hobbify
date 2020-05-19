import {HobbyVoModel} from './hobby-vo.model';

export class ProfileVoModel {

    uuid: string;

    firstName: string;

    lastName: string;

    customUserUuid: string;

    hobbies: HobbyVoModel[];

    description: string;
}
