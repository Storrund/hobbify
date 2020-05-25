package com.hobbify.service.vo;

public class HobbyVo {

    private String uuid;

    private String name;
    private String iconTag;
    private String hobbyCategoryUuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconTag() {
        return iconTag;
    }

    public void setIconTag(String iconTag) {
        this.iconTag = iconTag;
    }

    public String getHobbyCategoryUuid() {
        return hobbyCategoryUuid;
    }

    public void setHobbyCategoryUuid(String hobbyCategoryUuid) {
        this.hobbyCategoryUuid = hobbyCategoryUuid;
    }
}
