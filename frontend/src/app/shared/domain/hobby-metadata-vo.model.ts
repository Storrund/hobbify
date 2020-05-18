import {HobbyCategoryVoModel} from './hobby-category-vo.model';
import {HobbyVoModel} from './hobby-vo.model';

export class HobbyMetadataVoModel {

    hobbies: Map<string, HobbyVoModel[]>;

    hobbyCategories: HobbyCategoryVoModel[];

}
