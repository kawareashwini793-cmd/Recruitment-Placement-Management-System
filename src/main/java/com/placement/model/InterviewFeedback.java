
package com.placement.model;

public class InterviewFeedback {

    private int feedbackId;
    private int interviewId;
    private String feedback;
    private String result;

    public InterviewFeedback() {
    }

    public InterviewFeedback(int interviewId, String feedback, String result) {
        this.interviewId = interviewId;
        this.feedback = feedback;
        this.result = result;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(int interviewId) {
        this.interviewId = interviewId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
