
package com.placement.dao;

import com.placement.model.Interview;
import com.placement.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InterviewDAO {

    public boolean scheduleInterview(Interview interview)
            throws SQLException {

        String sql = "INSERT INTO interviews "
                + "(application_id, interview_round, interview_date, interview_status) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, interview.getApplicationId());
            ps.setString(2, interview.getInterviewRound());
            ps.setTimestamp(3, interview.getInterviewDate());
            ps.setString(4, interview.getInterviewStatus());

            return ps.executeUpdate() > 0;
        }
    }

    public List<Interview> getAllInterviews()
            throws SQLException {

        List<Interview> interviews = new ArrayList<>();

        String sql = "SELECT interview_id, application_id, "
                + "interview_round, interview_date, interview_status "
                + "FROM interviews";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Interview interview = new Interview();

                interview.setInterviewId(
                        rs.getInt("interview_id"));

                interview.setApplicationId(
                        rs.getInt("application_id"));

                interview.setInterviewRound(
                        rs.getString("interview_round"));

                interview.setInterviewDate(
                        rs.getTimestamp("interview_date"));

                interview.setInterviewStatus(
                        rs.getString("interview_status"));

                interviews.add(interview);
            }
        }

        return interviews;
    }
}
