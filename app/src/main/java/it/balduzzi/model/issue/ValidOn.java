package it.balduzzi.model.issue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ValidOn {
    @SerializedName("publicationId")
    @Expose
    private String publicationId;
    @SerializedName("issueId")
    @Expose
    private String issueId;

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
}
