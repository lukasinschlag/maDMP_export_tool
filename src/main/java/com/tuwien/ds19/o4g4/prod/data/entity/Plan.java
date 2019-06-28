package com.tuwien.ds19.o4g4.prod.data.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "plans")
public class Plan {

    @Id
    private int id;
    private String title;

    private String description;
    private String principal_investigator;
    private String principal_investigator_identifier;
    private String principal_investigator_email;
    private String principal_investigator_phone;
    private String grant_number;
    private String funder_name;

    @Column(name = "identifier")
    private String dmp_id;

    @Column(name = "created_at", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name = "updated_at", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getPrincipal_investigator() {
        return principal_investigator;
    }

    public void setPrincipal_investigator(String principal_investigator) {
        this.principal_investigator = principal_investigator;
    }

    public String getPrincipal_investigator_identifier() {
        return principal_investigator_identifier;
    }

    public void setPrincipal_investigator_identifier(String principal_investigator_identifier) {
        this.principal_investigator_identifier = principal_investigator_identifier;
    }

    public String getPrincipal_investigator_email() {
        return principal_investigator_email;
    }

    public void setPrincipal_investigator_email(String principal_investigator_email) {
        this.principal_investigator_email = principal_investigator_email;
    }

    public String getPrincipal_investigator_phone() {
        return principal_investigator_phone;
    }

    public void setPrincipal_investigator_phone(String principal_investigator_phone) {
        this.principal_investigator_phone = principal_investigator_phone;
    }

    public String getGrant_number() {
        return grant_number;
    }

    public void setGrant_number(String grant_number) {
        this.grant_number = grant_number;
    }

    public String getDmp_id() {
        return dmp_id;
    }

    public void setDmp_id(String dmp_id) {
        this.dmp_id = dmp_id;
    }

    public String getFunder_name() {
        return funder_name;
    }

    public void setFunder_name(String funder_name) {
        this.funder_name = funder_name;
    }
}
