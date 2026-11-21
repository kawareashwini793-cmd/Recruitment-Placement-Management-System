
package com.placement.service;

import com.placement.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EligibilityService {

    public boolean checkEligibility(int candidateId, int jobId)
            throws SQLException {

        String sql = "SELECT c.percentage, c.passing_year, "
                + "c.backlogs, j.minimum_percentage, "
                + "j.passing_year AS required_year, "
                + "j.maximum_backlogs "
                + "FROM candidates c "
                + "JOIN jobs j ON j.job_id = ? "
                + "WHERE c.candidate_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, jobId);
            ps.setInt(2, candidateId);

            try (ResultSet rs = ps.executeQuery()) {

                if (!rs.next()) {
                    throw new SQLException(
                            "Candidate or Job not found.");
                }

                double percentage = rs.getDouble("percentage");
                int candidateYear = rs.getInt("passing_year");
                int backlogs = rs.getInt("backlogs");

                double minimumPercentage =
                        rs.getDouble("minimum_percentage");

                int requiredYear = rs.getInt("required_year");
                int maximumBacklogs =
                        rs.getInt("maximum_backlogs");

                boolean percentageOK =
                        rs.wasNull() ? true :
                        percentage >= minimumPercentage;

                boolean yearOK =
                        requiredYear == 0 ||
                        candidateYear == requiredYear;

                boolean backlogOK =
                        backlogs <= maximumBacklogs;

                return percentageOK && yearOK && backlogOK;
            }
        }
    }
}
