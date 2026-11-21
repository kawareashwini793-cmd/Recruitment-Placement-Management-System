
package com.placement.model;

import java.math.BigDecimal;

public class Job {

    private int jobId;
    private int companyId;
    private String jobTitle;
    private String jobDescription;
    private BigDecimal minimumPercentage;
    private Integer passingYear;
    private Integer maximumBacklogs;

    public Job() {
    }

    public Job(int companyId, String jobTitle,
               String jobDescription, BigDecimal minimumPercentage,
               Integer passingYear, Integer maximumBacklogs) {

        this.companyId = companyId;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.minimumPercentage = minimumPercentage;
        this.passingYear = passingYear;
        this.maximumBacklogs = maximumBacklogs;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public BigDecimal getMinimumPercentage() {
        return minimumPercentage;
    }

    public void setMinimumPercentage(BigDecimal minimumPercentage) {
        this.minimumPercentage = minimumPercentage;
    }

    public Integer getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(Integer passingYear) {
        this.passingYear = passingYear;
    }

    public Integer getMaximumBacklogs() {
        return maximumBacklogs;
    }

    public void setMaximumBacklogs(Integer maximumBacklogs) {
        this.maximumBacklogs = maximumBacklogs;
    }
}
