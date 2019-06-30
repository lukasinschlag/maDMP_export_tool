package com.tuwien.ds19.o4g4.prod.data.entity.madmp;

import java.util.ArrayList;
import java.util.List;

public class Dataset {

    private String title;
    private String description;
    private String type;
    private String personalData;
    private String sensitiveData;
    private String dataQualityAssurance;
    private String preservationStatement;
    private Dataset_Id dataset_id;

    private List<String> keyword;
    private List<Distribution> distribution;
    private List<Metadata> metadata;
    private List<TechnicalResource> technicalResource;
    private List<SecurityAndPrivacy> securityAndPrivacy;

    public Dataset() {
    }

    public Dataset(Distribution distribution) {
        this.distribution = new ArrayList<>();
        this.distribution.add(distribution);
        this.metadata = new ArrayList<>();
        this.technicalResource = new ArrayList<>();
        this.securityAndPrivacy = new ArrayList<>();
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
        if (this.description == null || this.description.isEmpty()) {
            this.description = description;
        } else {
            this.description = this.description + ", " + description;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPersonalData() {
        return personalData;
    }

    public void setPersonalData(String personalData) {
        this.personalData = personalData;
    }

    public String getSensitiveData() {
        return sensitiveData;
    }

    public void setSensitiveData(String sensitiveData) {
        this.sensitiveData = sensitiveData;
    }

    public String getDataQualityAssurance() {
        return dataQualityAssurance;
    }

    public void setDataQualityAssurance(String dataQualityAssurance) {
        if (this.dataQualityAssurance == null || this.dataQualityAssurance.isEmpty()) {
            this.dataQualityAssurance = dataQualityAssurance;
        } else {
            this.dataQualityAssurance = this.dataQualityAssurance + ", " + dataQualityAssurance;
        }
    }

    public String getPreservationStatement() {
        return preservationStatement;
    }

    public void setPreservationStatement(String preservationStatement) {

        this.preservationStatement = preservationStatement;
    }

    public List<String> getKeyword() {
        return keyword;
    }

    public void setKeyword(List<String> keyword) {
        this.keyword = keyword;
    }

    public List<Distribution> getDistribution() {
        return distribution;
    }

    public void setDistribution(List<Distribution> distribution) {
        this.distribution = distribution;
    }

    public List<Metadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<Metadata> metadata) {
        this.metadata = metadata;
    }

    public List<TechnicalResource> getTechnicalResource() {
        return technicalResource;
    }

    public void setTechnicalResource(List<TechnicalResource> technicalResource) {
        this.technicalResource = technicalResource;
    }

    public List<SecurityAndPrivacy> getSecurityAndPrivacy() {
        return securityAndPrivacy;
    }

    public void setSecurityAndPrivacy(List<SecurityAndPrivacy> securityAndPrivacy) {
        this.securityAndPrivacy = securityAndPrivacy;
    }

    public Dataset_Id getDataset_id() {
        return dataset_id;
    }

    public void setDataset_id(Dataset_Id dataset_id) {
        this.dataset_id = dataset_id;
    }

    public enum  DatasetTypeEnum {
        software, document, questionnaire, interview, observation, measurements, recordings
    }
}
