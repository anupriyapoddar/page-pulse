package com.digitalheroes.anupriya.sde.page_pulse.model;

public class AuditResponse {
    private String url;
    private int httpStatus;
    private long responseTimeMs;
    private String pageTitle;
    private String metaDescription;
    private int h1Count;
    private int missingAltImagesCount;
    private int approximateWordCount;

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public int getHttpStatus() { return httpStatus; }
    public void setHttpStatus(int httpStatus) { this.httpStatus = httpStatus; }
    public long getResponseTimeMs() { return responseTimeMs; }
    public void setResponseTimeMs(long responseTimeMs) { this.responseTimeMs = responseTimeMs; }
    public String getPageTitle() { return pageTitle; }
    public void setPageTitle(String pageTitle) { this.pageTitle = pageTitle; }
    public String getMetaDescription() { return metaDescription; }
    public void setMetaDescription(String metaDescription) { this.metaDescription = metaDescription; }
    public int getH1Count() { return h1Count; }
    public void setH1Count(int h1Count) { this.h1Count = h1Count; }
    public int getMissingAltImagesCount() { return missingAltImagesCount; }
    public void setMissingAltImagesCount(int missingAltImagesCount) { this.missingAltImagesCount = missingAltImagesCount; }
    public int getApproximateWordCount() { return approximateWordCount; }
    public void setApproximateWordCount(int approximateWordCount) { this.approximateWordCount = approximateWordCount; }
}
