package com.tuwien.ds19.o4g4.prod.data.entity.madmp;

import java.util.Date;

public class License {

    private String license_ref;
    private Date startDate;

    public String getLicense_ref() {
        return license_ref;
    }

    public void setLicense_ref(String license_ref) {
        this.license_ref = license_ref;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
