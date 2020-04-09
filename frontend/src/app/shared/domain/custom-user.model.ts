import {AuthorityModel} from './authority.model';

export class CustomUserModel {

    id: number;

    username: string;

    firstName: string;

    lastName: string;

    authorities: AuthorityModel[];

}
