package it.balduzzi.model.issue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Variants {

    @SerializedName("variantId")
    @Expose
    private int variantId;

    @SerializedName("issueUniqueId")
    @Expose
    private int issueUniqueId;

    @SerializedName("platform")
    @Expose
    private String platform;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("narrowDimension")
    @Expose
    private int narrowDimension;

    @SerializedName("wideDimension")
    @Expose
    private int wideDimension;

    @SerializedName("uploadFilename")
    @Expose
    private String uploadFilename;

    @SerializedName("metadataModifiedOn")
    @Expose
    private String metadataModifiedOn;

    @SerializedName("uploadedOn")
    @Expose
    private String uploadedOn;

    @SerializedName("deletedOn")
    @Expose
    private String deletedOn;

    @SerializedName("imagesUrl")
    @Expose
    private String imagesUrl;

    @SerializedName("mediumImagesUrl")
    @Expose
    private String mediumImagesUrl;

    @SerializedName("smallImagesUrl")
    @Expose
    private String smallImagesUrl;

    @SerializedName("previewPages")
    @Expose
    private List<Object> previewPages;

    @SerializedName("hasPreview")
    @Expose
    private boolean hasPreview;

    @SerializedName("hasHtml")
    @Expose
    private boolean hasHtml;
    @SerializedName("htmlUrl")
    @Expose
    private String htmlUrl;

    @SerializedName("propertiesJson")
    @Expose
    private String propertiesJson;


    @SerializedName("default")
    @Expose
    private boolean defaultProperty;


    @SerializedName("aspectRatio")
    @Expose
    private double aspectRatio;

    @SerializedName("numberOfPages")
    @Expose
    private int numberOfPages;

    @SerializedName("tableOfContents")
    @Expose
    private String tableOfContents;

    @SerializedName("tags")
    @Expose
    private List<Object> tags;

    @SerializedName("thumbnailsUrl")
    @Expose
    private String thumbnailsUrl;

    public int getVariantId() {
        return variantId;
    }

    public void setVariantId(int variantId) {
        this.variantId = variantId;
    }

    public int getIssueUniqueId() {
        return issueUniqueId;
    }

    public void setIssueUniqueId(int issueUniqueId) {
        this.issueUniqueId = issueUniqueId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNarrowDimension() {
        return narrowDimension;
    }

    public void setNarrowDimension(int narrowDimension) {
        this.narrowDimension = narrowDimension;
    }

    public int getWideDimension() {
        return wideDimension;
    }

    public void setWideDimension(int wideDimension) {
        this.wideDimension = wideDimension;
    }

    public String getUploadFilename() {
        return uploadFilename;
    }

    public void setUploadFilename(String uploadFilename) {
        this.uploadFilename = uploadFilename;
    }

    public String getMetadataModifiedOn() {
        return metadataModifiedOn;
    }

    public void setMetadataModifiedOn(String metadataModifiedOn) {
        this.metadataModifiedOn = metadataModifiedOn;
    }

    public String getUploadedOn() {
        return uploadedOn;
    }

    public void setUploadedOn(String uploadedOn) {
        this.uploadedOn = uploadedOn;
    }

    public String getDeletedOn() {
        return deletedOn;
    }

    public void setDeletedOn(String deletedOn) {
        this.deletedOn = deletedOn;
    }

    public String getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public String getMediumImagesUrl() {
        return mediumImagesUrl;
    }

    public void setMediumImagesUrl(String mediumImagesUrl) {
        this.mediumImagesUrl = mediumImagesUrl;
    }

    public String getSmallImagesUrl() {
        return smallImagesUrl;
    }

    public void setSmallImagesUrl(String smallImagesUrl) {
        this.smallImagesUrl = smallImagesUrl;
    }

    public List<Object> getPreviewPages() {
        return previewPages;
    }

    public void setPreviewPages(List<Object> previewPages) {
        this.previewPages = previewPages;
    }

    public boolean isHasPreview() {
        return hasPreview;
    }

    public void setHasPreview(boolean hasPreview) {
        this.hasPreview = hasPreview;
    }

    public boolean isHasHtml() {
        return hasHtml;
    }

    public void setHasHtml(boolean hasHtml) {
        this.hasHtml = hasHtml;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getPropertiesJson() {
        return propertiesJson;
    }

    public void setPropertiesJson(String propertiesJson) {
        this.propertiesJson = propertiesJson;
    }

    public boolean isDefaultProperty() {
        return defaultProperty;
    }

    public void setDefaultProperty(boolean defaultProperty) {
        this.defaultProperty = defaultProperty;
    }

    public double getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(double aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getTableOfContents() {
        return tableOfContents;
    }

    public void setTableOfContents(String tableOfContents) {
        this.tableOfContents = tableOfContents;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public String getThumbnailsUrl() {
        return thumbnailsUrl;
    }

    public void setThumbnailsUrl(String thumbnailsUrl) {
        this.thumbnailsUrl = thumbnailsUrl;
    }
}
