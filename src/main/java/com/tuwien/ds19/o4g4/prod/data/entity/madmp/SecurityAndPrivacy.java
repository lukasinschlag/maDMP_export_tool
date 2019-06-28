package com.tuwien.ds19.o4g4.prod.data.entity.madmp;

public class SecurityAndPrivacy {

    private String title;
    private String description;

    public SecurityAndPrivacy(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
