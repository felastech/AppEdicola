package it.balduzzi.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("publicationId")
    @Expose
    private String publicationId;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("propertiesJson")
    @Expose
    private PropertiesJson propertiesJson;
    @SerializedName("projectId")
    @Expose
    private String projectId;
    @SerializedName("readersEmail")
    @Expose
    private Object readersEmail;
    @SerializedName("supportEmail")
    @Expose
    private Object supportEmail;
    @SerializedName("autoPublish")
    @Expose
    private Boolean autoPublish;
    @SerializedName("maxNumberOfIssues")
    @Expose
    private Integer maxNumberOfIssues;
    @SerializedName("createdOn")
    @Expose
    private String createdOn;
    @SerializedName("updatedOn")
    @Expose
    private String updatedOn;
    @SerializedName("deletedOn")
    @Expose
    private Object deletedOn;
    @SerializedName("sortingPosition")
    @Expose
    private Object sortingPosition;
    @SerializedName("publicationName")
    @Expose
    private String publicationName;
    @SerializedName("storageLocation")
    @Expose
    private String storageLocation;

    public String getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(String publicationId) {
        this.publicationId = publicationId;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public PropertiesJson getPropertiesJson() {
        return propertiesJson;
    }

    public void setPropertiesJson(PropertiesJson propertiesJson) {
        this.propertiesJson = propertiesJson;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Object getReadersEmail() {
        return readersEmail;
    }

    public void setReadersEmail(Object readersEmail) {
        this.readersEmail = readersEmail;
    }

    public Object getSupportEmail() {
        return supportEmail;
    }

    public void setSupportEmail(Object supportEmail) {
        this.supportEmail = supportEmail;
    }

    public Boolean getAutoPublish() {
        return autoPublish;
    }

    public void setAutoPublish(Boolean autoPublish) {
        this.autoPublish = autoPublish;
    }

    public Integer getMaxNumberOfIssues() {
        return maxNumberOfIssues;
    }

    public void setMaxNumberOfIssues(Integer maxNumberOfIssues) {
        this.maxNumberOfIssues = maxNumberOfIssues;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Object getDeletedOn() {
        return deletedOn;
    }

    public void setDeletedOn(Object deletedOn) {
        this.deletedOn = deletedOn;
    }

    public Object getSortingPosition() {
        return sortingPosition;
    }

    public void setSortingPosition(Object sortingPosition) {
        this.sortingPosition = sortingPosition;
    }

    public String getPublicationName() {
        return publicationName;
    }

    public void setPublicationName(String publicationName) {
        this.publicationName = publicationName;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }
}

