package com.hobbify.model;

import com.hobbify.model.common.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name="hobby")
public class Hobby extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "icon_tag", nullable = false)
    private String iconTag;


    @OneToOne
    @JoinColumn(name = "hobby_category_uuid", foreignKey = @ForeignKey(name = "FK_HOBBY__HOBBY_CATEGORY"))
    private HobbyCategory hobbyCategory;

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

    public HobbyCategory getHobbyCategory() {
        return hobbyCategory;
    }

    public void setHobbyCategory(HobbyCategory hobbyCategory) {
        this.hobbyCategory = hobbyCategory;
    }
}
