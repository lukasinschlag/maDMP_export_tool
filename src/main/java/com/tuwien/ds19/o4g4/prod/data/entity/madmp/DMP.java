package com.tuwien.ds19.o4g4.prod.data.entity.madmp;

import java.util.Date;
import java.util.List;

public class DMP {

    private String title;
    private String description;
    private String language;
    private Date created;
    private Date modified;

    private Contact contact;

    private List<DMStaff> dmStaff;
    private List<Project> project;
    private List<Cost> cost;
    private List<Dataset> dataset;

    //TODO: ethicalIssues

    public DMP() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DMStaff> getDmStaff() {
        return dmStaff;
    }

    public void setDmStaff(List<DMStaff> dmStaff) {
        this.dmStaff = dmStaff;
    }

    public List<Cost> getCost() {
        return cost;
    }

    public void setCost(List<Cost> cost) {
        this.cost = cost;
    }

    public List<Dataset> getDataset() {
        return dataset;
    }

    public void setDataset(List<Dataset> dataset) {
        this.dataset = dataset;
    }
}
