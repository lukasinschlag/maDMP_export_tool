package com.tuwien.ds19.o4g4.prod.data.entity;

public class Project {

    private String title;
    private String description;

    private Funding funding;

    public Project(String title, String description, Funding funding) {
        this.title = title;
        this.description = description;
        this.funding = funding;
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

    public Funding getFunding() {
        return funding;
    }

    public void setFunding(Funding funding) {
        this.funding = funding;
    }
}
