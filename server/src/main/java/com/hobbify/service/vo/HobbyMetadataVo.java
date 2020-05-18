package com.hobbify.service.vo;

import java.util.List;

public class HobbyMetadataVo {

    private List<HobbyCategoryVo> hobbyCategories;
    private List<HobbyVo> hobbies;

    public List<HobbyCategoryVo> getHobbyCategories() {
        return hobbyCategories;
    }

    public void setHobbyCategories(List<HobbyCategoryVo> hobbyCategories) {
        this.hobbyCategories = hobbyCategories;
    }

    public List<HobbyVo> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<HobbyVo> hobbies) {
        this.hobbies = hobbies;
    }
}
