
package com.placement.model;

import java.sql.Timestamp;

public class Interview {

    private int interviewId;
    private int applicationId;
    private String interviewRound;
    private Timestamp interviewDate;
    private String interviewStatus;

    public Interview() {
    }

    public Interview(int applicationId, String interviewRound,
                     Timestamp interviewDate, String interviewStatus) {
        this.applicationId = applicationId;
        this.interviewRound = interviewRound;
        this.interviewDate = interviewDate;
        this.interviewStatus = interviewStatus;
    }

    public int getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(int interviewId) {
        this.interviewId = interviewId;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getInterviewRound() {
        return interviewRound;
    }

    public void setInterviewRound(String interviewRound) {
        this.interviewRound = interviewRound;
    }

    public Timestamp getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Timestamp interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(String interviewStatus) {
        this.interviewStatus = interviewStatus;
    }
}
