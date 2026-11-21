
package com.placement.dao;

import com.placement.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportDAO {

    public void generatePlacementReport() throws SQLException {

        String sql = "SELECT c.full_name, co.company_name, "
                + "j.job_title, p.joining_date, p.joining_status "
                + "FROM placements p "
                + "JOIN candidates c ON p.candidate_id = c.candidate_id "
                + "JOIN companies co ON p.company_id = co.company_id "
                + "JOIN jobs j ON p.job_id = j.job_id";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n========== PLACEMENT REPORT ==========");

            System.out.printf("%-20s %-20s %-20s %-15s %-15s%n",
                    "Candidate", "Company", "Job Title",
                    "Joining Date", "Status");

            System.out.println(
                    "--------------------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-20s %-20s %-20s %-15s %-15s%n",
                        rs.getString("full_name"),
                        rs.getString("company_name"),
                        rs.getString("job_title"),
                        rs.getDate("joining_date"),
                        rs.getString("joining_status"));
            }
        }
    }
}
