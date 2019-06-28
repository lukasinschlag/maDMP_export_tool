package com.tuwien.ds19.o4g4.prod.data.entity.madmp;

public class TextType_Id implements TypedIdentifier {

    private String id;
    private String type = "TEXT";

    public TextType_Id(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
