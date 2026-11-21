
package com.placement.service;

import com.placement.dao.JobDAO;
import com.placement.model.Job;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class JobService {

    private final JobDAO jobDAO = new JobDAO();

    public boolean addJob(Job job) throws SQLException {

        if (job == null) {
            throw new IllegalArgumentException("Job cannot be null.");
        }

        if (job.getCompanyId() <= 0) {
            throw new IllegalArgumentException("Valid Company ID is required.");
        }

        if (job.getJobTitle() == null || job.getJobTitle().isBlank()) {
            throw new IllegalArgumentException("Job title is required.");
        }

        if (job.getMinimumPercentage() != null
                && (job.getMinimumPercentage().compareTo(BigDecimal.ZERO) < 0
                || job.getMinimumPercentage().compareTo(
                        new BigDecimal("100")) > 0)) {
            throw new IllegalArgumentException(
                    "Percentage must be between 0 and 100.");
        }

        if (job.getPassingYear() != null
                && (job.getPassingYear() < 2000
                || job.getPassingYear() > 2100)) {
            throw new IllegalArgumentException("Invalid passing year.");
        }

        if (job.getMaximumBacklogs() != null
                && job.getMaximumBacklogs() < 0) {
            throw new IllegalArgumentException(
                    "Maximum backlogs cannot be negative.");
        }

        return jobDAO.addJob(job);
    }

    public List<Job> getAllJobs() throws SQLException {
        return jobDAO.getAllJobs();
    }
}

