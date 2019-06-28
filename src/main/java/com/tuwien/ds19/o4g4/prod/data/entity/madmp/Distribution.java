package com.tuwien.ds19.o4g4.prod.data.entity.madmp;

public class Distribution {

    private String title;
    private String description;
    private String format;
    private String accessURL;
    private String downloadURL;
    private int byteSize;

    public Distribution() {
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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getAccessURL() {
        return accessURL;
    }

    public void setAccessURL(String accessURL) {
        this.accessURL = accessURL;
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public void setDownloadURL(String downloadURL) {
        this.downloadURL = downloadURL;
    }

    public void setByteSize(int byteSize) {
        this.byteSize = byteSize;
    }

    public int getByteSize() {
        return byteSize;
    }

    public enum DatasetFormat {
        csv, xsl, xsls, xslx, pdf, txt
    }
}
