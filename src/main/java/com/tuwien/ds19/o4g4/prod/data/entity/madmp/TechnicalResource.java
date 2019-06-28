package com.tuwien.ds19.o4g4.prod.data.entity.madmp;

public class TechnicalResource {

    private String description;
    private TypedIdentifier type;

    public TechnicalResource(String description) {
        this.description = description;
    }

    public TechnicalResource(String description, TypedIdentifier type) {
        this(description);
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypedIdentifier getType() {
        return type;
    }

    public void setType(TypedIdentifier type) {
        this.type = type;
    }
}
