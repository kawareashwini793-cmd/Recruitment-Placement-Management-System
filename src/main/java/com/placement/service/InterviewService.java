
package com.placement.service;

import com.placement.dao.InterviewDAO;
import com.placement.model.Interview;

import java.sql.SQLException;
import java.util.List;

public class InterviewService {

    private final InterviewDAO interviewDAO = new InterviewDAO();

    public boolean scheduleInterview(Interview interview)
            throws SQLException {

        if (interview == null) {
            throw new IllegalArgumentException(
                    "Interview cannot be null.");
        }

        if (interview.getApplicationId() <= 0) {
            throw new IllegalArgumentException(
                    "Valid Application ID is required.");
        }

        if (interview.getInterviewRound() == null
                || interview.getInterviewRound().isBlank()) {
            throw new IllegalArgumentException(
                    "Interview round is required.");
        }

        if (interview.getInterviewDate() == null) {
            throw new IllegalArgumentException(
                    "Interview date is required.");
        }

        if (interview.getInterviewStatus() == null
                || interview.getInterviewStatus().isBlank()) {
            throw new IllegalArgumentException(
                    "Interview status is required.");
        }

        return interviewDAO.scheduleInterview(interview);
    }

    public List<Interview> getAllInterviews()
            throws SQLException {

        return interviewDAO.getAllInterviews();
    }
}

