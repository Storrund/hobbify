import {AuthorityModel} from './authority.model';

export class CustomUserModel {

    uuid: string;

    username: string;

    firstName: string;

    lastName: string;

    authorities: AuthorityModel[];

}
