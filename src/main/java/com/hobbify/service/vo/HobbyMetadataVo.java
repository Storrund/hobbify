package com.hobbify.service.vo;

import java.util.List;
import java.util.Map;

public class HobbyMetadataVo {

    private List<HobbyCategoryVo> hobbyCategories;
    private Map<String,List<HobbyVo>> hobbies;

    public List<HobbyCategoryVo> getHobbyCategories() {
        return hobbyCategories;
    }

    public void setHobbyCategories(List<HobbyCategoryVo> hobbyCategories) {
        this.hobbyCategories = hobbyCategories;
    }

    public Map<String,List<HobbyVo>> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Map<String,List<HobbyVo>> hobbies) {
        this.hobbies = hobbies;
    }
}
