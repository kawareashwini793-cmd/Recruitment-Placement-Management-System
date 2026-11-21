
package com.placement.model;

import java.sql.Timestamp;

public class Application {

    private int applicationId;
    private int candidateId;
    private int jobId;
    private Timestamp applicationDate;
    private String applicationStatus;

    public Application() {
    }

    public Application(int candidateId, int jobId,
                       String applicationStatus) {
        this.candidateId = candidateId;
        this.jobId = jobId;
        this.applicationStatus = applicationStatus;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public Timestamp getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Timestamp applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
