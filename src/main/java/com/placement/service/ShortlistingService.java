
package com.placement.service;

import com.placement.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShortlistingService {

    public boolean updateApplicationStatus(
            int applicationId, String status) throws SQLException {

        if (applicationId <= 0) {
            throw new IllegalArgumentException(
                    "Valid Application ID is required.");
        }

        if (status == null ||
                !status.matches("(?i)SHORTLISTED|REJECTED|SELECTED")) {
            throw new IllegalArgumentException(
                    "Status must be SHORTLISTED, REJECTED or SELECTED.");
        }

        String sql = "UPDATE applications "
                + "SET application_status = ? "
                + "WHERE application_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status.toUpperCase());
            ps.setInt(2, applicationId);

            return ps.executeUpdate() > 0;
        }
    }
}
