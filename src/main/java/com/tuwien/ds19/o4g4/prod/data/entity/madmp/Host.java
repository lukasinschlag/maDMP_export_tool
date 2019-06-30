package com.tuwien.ds19.o4g4.prod.data.entity.madmp;

public class Host {

    private String title;
    private String description;
    private String storage_type;
    private String backup_type;
    private String supports_versioning;

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

    public String getSupports_versioning() {
        return supports_versioning;
    }

    public String getStorage_type() {
        return storage_type;
    }

    public void setStorage_type(String storage_type) {
        this.storage_type = storage_type;
    }

    public void setSupports_versioning(String supports_versioning) {
        this.supports_versioning = supports_versioning;
    }

    public String getBackup_type() {
        return backup_type;
    }

    public void setBackup_type(String backup_type) {
        this.backup_type = backup_type;
    }
}
