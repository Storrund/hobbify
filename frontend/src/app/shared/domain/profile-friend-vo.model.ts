import {ProfileVoModel} from './profile-vo.model';

export class ProfileFriendVoModel {

    uuid: string;

    firstProfile: string;

    secondProfile: string;

    accepted: boolean;

    firstProfileVo: ProfileVoModel;
}
