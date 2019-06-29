package com.tuwien.ds19.o4g4.prod.data.entity.madmp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {

    private String title;
    private String description;
    private Date projectStart;
    private Date projectEnd;
    private List<Funding> funding;

    public Project(String title, String description) {
        this.title = title;
        this.description = description;
        this.funding = new ArrayList<>();
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

    public List<Funding> getFunding() {
        return funding;
    }

    public void addFunding(Funding funding) {
        this.funding.add(funding);
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
