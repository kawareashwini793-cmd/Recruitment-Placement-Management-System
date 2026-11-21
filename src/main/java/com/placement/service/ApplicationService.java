
package com.placement.service;

import com.placement.dao.ApplicationDAO;
import com.placement.model.Application;

import java.sql.SQLException;
import java.util.List;

public class ApplicationService {

    private final ApplicationDAO applicationDAO =
            new ApplicationDAO();

    public boolean applyForJob(Application application)
            throws SQLException {

        if (application == null) {
            throw new IllegalArgumentException(
                    "Application cannot be null.");
        }

        if (application.getCandidateId() <= 0) {
            throw new IllegalArgumentException(
                    "Valid Candidate ID is required.");
        }

        if (application.getJobId() <= 0) {
            throw new IllegalArgumentException(
                    "Valid Job ID is required.");
        }

        if (application.getApplicationStatus() == null
                || application.getApplicationStatus().isBlank()) {
            throw new IllegalArgumentException(
                    "Application status is required.");
        }

        return applicationDAO.applyForJob(application);
    }

    public List<Application> getAllApplications()
            throws SQLException {
        return applicationDAO.getAllApplications();
    }
}
