package com.tuwien.ds19.o4g4.prod.data.entity.madmp;

public class Metadata {

    private String description;
    private String language = "en";
    private TypedIdentifier type;

    public Metadata(String description) {
        this.description = description;
    }

    public Metadata(String description, TypedIdentifier type) {
        this(description);
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public TypedIdentifier getType() {
        return type;
    }

    public void setType(TypedIdentifier type) {
        this.type = type;
    }
}
