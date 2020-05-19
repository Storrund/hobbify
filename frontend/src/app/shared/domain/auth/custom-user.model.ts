import {AuthorityModel} from './authority.model';

export class CustomUserModel {

    uuid: string;

    username: string;

    authorities: AuthorityModel[];

}
