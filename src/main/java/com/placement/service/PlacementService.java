
package com.placement.service;

import com.placement.dao.PlacementDAO;
import com.placement.model.Placement;

import java.sql.SQLException;
import java.util.List;

public class PlacementService {

    private final PlacementDAO placementDAO = new PlacementDAO();

    public boolean createPlacement(Placement placement)
            throws SQLException {

        if (placement == null) {
            throw new IllegalArgumentException("Placement cannot be null.");
        }

        if (placement.getCandidateId() <= 0) {
            throw new IllegalArgumentException("Valid Candidate ID is required.");
        }

        if (placement.getCompanyId() <= 0) {
            throw new IllegalArgumentException("Valid Company ID is required.");
        }

        if (placement.getJobId() <= 0) {
            throw new IllegalArgumentException("Valid Job ID is required.");
        }

        if (placement.getJoiningDate() == null) {
            throw new IllegalArgumentException("Joining date is required.");
        }

        String status = placement.getJoiningStatus();

        if (status == null ||
                !status.trim().matches("(?i)OFFERED|ACCEPTED|JOINED|NOT JOINED")) {
            throw new IllegalArgumentException(
                    "Status must be OFFERED, ACCEPTED, JOINED or NOT JOINED.");
        }

        placement.setJoiningStatus(status.trim().toUpperCase());

        return placementDAO.addPlacement(placement);
    }

    public List<Placement> getAllPlacements() throws SQLException {
        return placementDAO.getAllPlacements();
    }
}
