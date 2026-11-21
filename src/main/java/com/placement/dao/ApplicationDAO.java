
package com.placement.dao;

import com.placement.model.Application;
import com.placement.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDAO {

    public boolean applyForJob(Application application)
            throws SQLException {

        String sql = "INSERT INTO applications "
                + "(candidate_id, job_id, application_status) "
                + "VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, application.getCandidateId());
            ps.setInt(2, application.getJobId());
            ps.setString(3, application.getApplicationStatus());

            return ps.executeUpdate() > 0;
        }
    }

    public List<Application> getAllApplications()
            throws SQLException {

        List<Application> applications = new ArrayList<>();

        String sql = "SELECT application_id, candidate_id, job_id, "
                + "application_date, application_status "
                + "FROM applications";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Application application = new Application();

                application.setApplicationId(
                        rs.getInt("application_id"));

                application.setCandidateId(
                        rs.getInt("candidate_id"));

                application.setJobId(
                        rs.getInt("job_id"));

                Timestamp date =
                        rs.getTimestamp("application_date");

                application.setApplicationDate(date);

                application.setApplicationStatus(
                        rs.getString("application_status"));

                applications.add(application);
            }
        }

        return applications;
    }
}
