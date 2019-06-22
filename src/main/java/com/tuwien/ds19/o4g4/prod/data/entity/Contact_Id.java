package com.tuwien.ds19.o4g4.prod.data.entity;

public class Contact_Id {

    private String contact_id;
    private String contact_id_type = "HTTP-ORCID";

    public Contact_Id(String contact_id) {
        this.contact_id = contact_id;
    }

    public String getContact_id() {
        return contact_id;
    }

    public void setContact_id(String contact_id) {
        this.contact_id = contact_id;
    }

    public String getContact_id_type() {
        return contact_id_type;
    }

    public void setContact_id_type(String contact_id_type) {
        this.contact_id_type = contact_id_type;
    }
}
