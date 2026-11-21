
package com.placement.dao;

import com.placement.model.Job;
import com.placement.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {

    public boolean addJob(Job job) throws SQLException {

        String sql = "INSERT INTO jobs "
                + "(company_id, job_title, job_description, "
                + "minimum_percentage, passing_year, maximum_backlogs) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, job.getCompanyId());
            ps.setString(2, job.getJobTitle());
            ps.setString(3, job.getJobDescription());

            if (job.getMinimumPercentage() != null) {
                ps.setBigDecimal(4, job.getMinimumPercentage());
            } else {
                ps.setNull(4, java.sql.Types.DECIMAL);
            }

            if (job.getPassingYear() != null) {
                ps.setInt(5, job.getPassingYear());
            } else {
                ps.setNull(5, java.sql.Types.INTEGER);
            }

            if (job.getMaximumBacklogs() != null) {
                ps.setInt(6, job.getMaximumBacklogs());
            } else {
                ps.setNull(6, java.sql.Types.INTEGER);
            }

            return ps.executeUpdate() > 0;
        }
    }

    public List<Job> getAllJobs() throws SQLException {

        List<Job> jobs = new ArrayList<>();

        String sql = "SELECT job_id, company_id, job_title, "
                + "job_description, minimum_percentage, passing_year, "
                + "maximum_backlogs FROM jobs";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Job job = new Job();

                job.setJobId(rs.getInt("job_id"));
                job.setCompanyId(rs.getInt("company_id"));
                job.setJobTitle(rs.getString("job_title"));
                job.setJobDescription(rs.getString("job_description"));
                job.setMinimumPercentage(
                        rs.getBigDecimal("minimum_percentage"));
                
                int year = rs.getInt("passing_year");
                job.setPassingYear(rs.wasNull() ? null : year);

                int backlogs = rs.getInt("maximum_backlogs");
                job.setMaximumBacklogs(
                        rs.wasNull() ? null : backlogs);

                jobs.add(job);
            }
        }

        return jobs;
    }
}

