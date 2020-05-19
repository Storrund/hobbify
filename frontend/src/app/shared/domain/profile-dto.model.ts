import {HobbyVoModel} from './hobby-vo.model';

export class ProfileDtoModel {

    customUserUuid: string;

    firstName: string;

    lastName: string;

    hobbies: HobbyVoModel[];
}
