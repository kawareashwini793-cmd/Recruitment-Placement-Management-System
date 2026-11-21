
package com.placement.dao;

import com.placement.model.Candidate;
import com.placement.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {

    // Save candidate in database
    public boolean addCandidate(Candidate candidate) throws SQLException {

        String sql = "INSERT INTO candidates "
                + "(full_name, email, phone, qualification, passing_year) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, candidate.getFullName());
            ps.setString(2, candidate.getEmail());
            ps.setString(3, candidate.getPhone());
            ps.setString(4, candidate.getQualification());
            ps.setInt(5, candidate.getPassingYear());

            return ps.executeUpdate() > 0;
        }
    }

    // Get all candidates from database
    public List<Candidate> getAllCandidates() throws SQLException {

        List<Candidate> candidates = new ArrayList<>();

        String sql = "SELECT candidate_id, user_id, full_name, "
                + "email, phone, qualification, passing_year "
                + "FROM candidates";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Candidate candidate = new Candidate();

                candidate.setCandidateId(rs.getInt("candidate_id"));
                candidate.setUserId(rs.getInt("user_id"));
                candidate.setFullName(rs.getString("full_name"));
                candidate.setEmail(rs.getString("email"));
                candidate.setPhone(rs.getString("phone"));
                candidate.setQualification(rs.getString("qualification"));
                candidate.setPassingYear(rs.getInt("passing_year"));

                candidates.add(candidate);
            }
        }

        return candidates;
    }
}
