package com.tuwien.ds19.o4g4.prod.data.entity.madmp;

public class User_Id {
    
    private String user_id;
    private String user_id_type = "ORCID";

    public User_Id(String user_id) {
        this.user_id = user_id;
    }

    public User_Id(String user_id, String user_id_type) {
        this.user_id = user_id;
        this.user_id_type = user_id_type;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_id_type() {
        return user_id_type;
    }

    public void setUser_id_type(String user_id_type) {
        this.user_id_type = user_id_type;
    }
}
