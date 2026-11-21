
package com.placement.model;

import java.sql.Date;

public class Placement {

    private int placementId;
    private int candidateId;
    private int companyId;
    private int jobId;
    private Date joiningDate;
    private String joiningStatus;

    public Placement() {
    }

    public Placement(int candidateId, int companyId, int jobId,
                     Date joiningDate, String joiningStatus) {
        this.candidateId = candidateId;
        this.companyId = companyId;
        this.jobId = jobId;
        this.joiningDate = joiningDate;
        this.joiningStatus = joiningStatus;
    }

    public int getPlacementId() {
        return placementId;
    }

    public void setPlacementId(int placementId) {
        this.placementId = placementId;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getJoiningStatus() {
        return joiningStatus;
    }

    public void setJoiningStatus(String joiningStatus) {
        this.joiningStatus = joiningStatus;
    }
}
