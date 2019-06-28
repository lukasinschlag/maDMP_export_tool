package com.tuwien.ds19.o4g4.prod.data.entity.madmp;

import java.util.Date;

public class Project {

    private String title;
    private String description;
    private Date projectStart;
    private Date projectEnd;
    private Funding funding;

    public Project(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Project(String title, String description, Date projectStart, Date projectEnd, Funding funding) {
        this.title = title;
        this.description = description;
        this.projectStart = projectStart;
        this.projectEnd = projectEnd;
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

    public Date getProjectStart() {
        return projectStart;
    }

    public void setProjectStart(Date projectStart) {
        this.projectStart = projectStart;
    }

    public Date getProjectEnd() {
        return projectEnd;
    }

    public void setProjectEnd(Date projectEnd) {
        this.projectEnd = projectEnd;
    }
}
