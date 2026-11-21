
package com.placement.service;

import com.placement.dao.CandidateDAO;
import com.placement.model.Candidate;

import java.sql.SQLException;
import java.util.List;

public class CandidateService {

    private final CandidateDAO candidateDAO = new CandidateDAO();

    // Register a new candidate
    public boolean registerCandidate(Candidate candidate)
            throws SQLException {

        if (candidate == null) {
            throw new IllegalArgumentException("Candidate cannot be null.");
        }

        if (candidate.getFullName() == null
                || candidate.getFullName().isBlank()) {
            throw new IllegalArgumentException("Full name is required.");
        }

        if (candidate.getEmail() == null
                || !candidate.getEmail().matches(
                        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Enter a valid email.");
        }

        if (candidate.getPhone() == null
                || !candidate.getPhone().matches("\\d{10,15}")) {
            throw new IllegalArgumentException(
                    "Phone must contain 10 to 15 digits.");
        }

        if (candidate.getQualification() == null
                || candidate.getQualification().isBlank()) {
            throw new IllegalArgumentException(
                    "Qualification is required.");
        }

        if (candidate.getPassingYear() < 2000
                || candidate.getPassingYear() > 2100) {
            throw new IllegalArgumentException(
                    "Enter a valid passing year.");
        }

        return candidateDAO.addCandidate(candidate);
    }

    // View all candidates
    public List<Candidate> getAllCandidates() throws SQLException {
        return candidateDAO.getAllCandidates();
    }
}
