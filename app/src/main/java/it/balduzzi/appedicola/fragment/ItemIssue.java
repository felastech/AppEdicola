package it.balduzzi.appedicola.fragment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemIssue {


    @SerializedName("publicationId")
    @Expose
    private String publicationId;
    @SerializedName("issueId")
    @Expose
    private String issueId;
    @SerializedName("issueName")
    @Expose
    private String issueName;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("uploadedOn")
    @Expose
    private String uploadedOn;
    @SerializedName("publishedOn")
    @Expose
    private String publishedOn;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("pdfUrl")
    @Expose
    private String pdfUrl;
    @SerializedName("pdfSize")
    @Expose
    private int pdfSize;
    @SerializedName("metadataUrl")
    @Expose
    private String metadataUrl;
    @SerializedName("metadataModifiedOn")
    @Expose
    private String metadataModifiedOn;
    @SerializedName("uniqueId")
    @Expose
    private int uniqueId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("aspectRatio")
    @Expose
    private double aspectRatio;

    @SerializedName("isForSale")
    @Expose
    private boolean isForSale;
    @SerializedName("thumbnailsUrl")
    @Expose
    private String thumbnailsUrl;
    @SerializedName("tableOfContents")
    @Expose
    private String tableOfContents;

    @SerializedName("product")
    @Expose
    private Product product;

    @SerializedName("variants")
    @Expose
    private List<Variants> variants = null;


    public String getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(String publicationId) {
        this.publicationId = publicationId;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getIssueName() {
        return issueName;
    }

    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getUploadedOn() {
        return uploadedOn;
    }

    public void setUploadedOn(String uploadedOn) {
        this.uploadedOn = uploadedOn;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public int getPdfSize() {
        return pdfSize;
    }

    public void setPdfSize(int pdfSize) {
        this.pdfSize = pdfSize;
    }

    public String getMetadataUrl() {
        return metadataUrl;
    }

    public void setMetadataUrl(String metadataUrl) {
        this.metadataUrl = metadataUrl;
    }

    public String getMetadataModifiedOn() {
        return metadataModifiedOn;
    }

    public void setMetadataModifiedOn(String metadataModifiedOn) {
        this.metadataModifiedOn = metadataModifiedOn;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(double aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public boolean isForSale() {
        return isForSale;
    }

    public void setForSale(boolean forSale) {
        isForSale = forSale;
    }

    public String getThumbnailsUrl() {
        return thumbnailsUrl;
    }

    public void setThumbnailsUrl(String thumbnailsUrl) {
        this.thumbnailsUrl = thumbnailsUrl;
    }

    public String getTableOfContents() {
        return tableOfContents;
    }

    public void setTableOfContents(String tableOfContents) {
        this.tableOfContents = tableOfContents;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Variants> getVariants() {
        return variants;
    }

    public void setVariants(List<Variants> variants) {
        this.variants = variants;
    }
}
