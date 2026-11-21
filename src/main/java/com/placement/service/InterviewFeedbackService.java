
package com.placement.service;

import com.placement.dao.InterviewFeedbackDAO;
import com.placement.model.InterviewFeedback;

import java.sql.SQLException;
import java.util.List;

public class InterviewFeedbackService {

    private final InterviewFeedbackDAO feedbackDAO =
            new InterviewFeedbackDAO();

    public boolean addFeedback(InterviewFeedback feedback)
            throws SQLException {

        if (feedback == null) {
            throw new IllegalArgumentException(
                    "Feedback cannot be null.");
        }

        if (feedback.getInterviewId() <= 0) {
            throw new IllegalArgumentException(
                    "Valid Interview ID is required.");
        }

        if (feedback.getFeedback() == null
                || feedback.getFeedback().isBlank()) {
            throw new IllegalArgumentException(
                    "Feedback is required.");
        }

        if (feedback.getResult() == null
                || !feedback.getResult().matches(
                        "(?i)SELECTED|REJECTED|ON HOLD")) {
            throw new IllegalArgumentException(
                    "Result must be SELECTED, REJECTED or ON HOLD.");
        }
        feedback.setResult(feedback.getResult().trim());
        
       feedback.setResult(feedback.getResult().trim().toUpperCase());

        return feedbackDAO.addFeedback(feedback);
    }

    public List<InterviewFeedback> getAllFeedback()
            throws SQLException {
        return feedbackDAO.getAllFeedback();
    }
}
