
package com.placement.dao;

import com.placement.model.Placement;
import com.placement.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlacementDAO {

    public boolean addPlacement(Placement placement)
            throws SQLException {

        String sql = "INSERT INTO placements "
                + "(candidate_id, company_id, job_id, joining_date, joining_status) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, placement.getCandidateId());
            ps.setInt(2, placement.getCompanyId());
            ps.setInt(3, placement.getJobId());
            ps.setDate(4, placement.getJoiningDate());
            ps.setString(5, placement.getJoiningStatus());

            return ps.executeUpdate() > 0;
        }
    }

    public List<Placement> getAllPlacements()
            throws SQLException {

        List<Placement> placements = new ArrayList<>();

        String sql = "SELECT * FROM placements";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Placement placement = new Placement();

                placement.setPlacementId(rs.getInt("placement_id"));
                placement.setCandidateId(rs.getInt("candidate_id"));
                placement.setCompanyId(rs.getInt("company_id"));
                placement.setJobId(rs.getInt("job_id"));
                placement.setJoiningDate(rs.getDate("joining_date"));
                placement.setJoiningStatus(rs.getString("joining_status"));

                placements.add(placement);
            }
        }

        return placements;
    }
}
