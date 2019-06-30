package com.tuwien.ds19.o4g4.prod.data.entity.madmp;

public class DMStaff {

    private String name;
    private String mbox;
    private String contributerType;

    private User_Id userID;

    public DMStaff() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMbox() {
        return mbox;
    }

    public void setMbox(String mbox) {
        this.mbox = mbox;
    }

    public User_Id getUserID() {
        return userID;
    }

    public void setUserID(User_Id userID) {
        this.userID = userID;
    }

    public String getContributerType() {
        return contributerType;
    }

    public void setContributerType(String contributerType) {
        this.contributerType = contributerType;
    }
}
