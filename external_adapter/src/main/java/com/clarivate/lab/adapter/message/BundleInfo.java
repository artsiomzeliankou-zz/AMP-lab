package com.clarivate.lab.adapter.message;

public class BundleInfo {

    private String path;
    private String name;
    private int scholarlyItemsNumber;
    private int publicationArtifactsNumber;

    // fields for testing purposes
    private String pipsStatus;
    private String businessError;
    private String serviceException;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScholarlyItemsNumber() {
        return scholarlyItemsNumber;
    }

    public void setScholarlyItemsNumber(int scholarlyItemsNumber) {
        this.scholarlyItemsNumber = scholarlyItemsNumber;
    }

    public int getPublicationArtifactsNumber() {
        return publicationArtifactsNumber;
    }

    public void setPublicationArtifactsNumber(int publicationArtifactsNumber) {
        this.publicationArtifactsNumber = publicationArtifactsNumber;
    }

    public String getPipsStatus() {
        return pipsStatus;
    }

    public void setPipsStatus(String pipsStatus) {
        this.pipsStatus = pipsStatus;
    }

    public String getBusinessError() {
        return businessError;
    }

    public void setBusinessError(String businessError) {
        this.businessError = businessError;
    }

    public String getServiceException() {
        return serviceException;
    }

    public void setServiceException(String serviceException) {
        this.serviceException = serviceException;
    }

    @Override
    public String toString() {
        return "BundleInfo{" +
                "path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", scholarlyItemsNumber=" + scholarlyItemsNumber +
                ", publicationArtifactsNumber=" + publicationArtifactsNumber +
                ", pipsStatus='" + pipsStatus + '\'' +
                ", businessError='" + businessError + '\'' +
                ", serviceException='" + serviceException + '\'' +
                '}';
    }
}
