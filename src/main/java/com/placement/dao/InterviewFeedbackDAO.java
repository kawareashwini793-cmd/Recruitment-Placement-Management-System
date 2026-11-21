
package com.placement.dao;

import com.placement.model.InterviewFeedback;
import com.placement.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InterviewFeedbackDAO {

    public boolean addFeedback(InterviewFeedback feedback)
            throws SQLException {

        String sql = "INSERT INTO interview_feedback "
                + "(interview_id, feedback, result) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, feedback.getInterviewId());
            ps.setString(2, feedback.getFeedback());
            ps.setString(3, feedback.getResult());

            return ps.executeUpdate() > 0;
        }
    }

    public List<InterviewFeedback> getAllFeedback()
            throws SQLException {

        List<InterviewFeedback> list = new ArrayList<>();

        String sql = "SELECT feedback_id, interview_id, feedback, result "
                + "FROM interview_feedback";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                InterviewFeedback f = new InterviewFeedback();

                f.setFeedbackId(rs.getInt("feedback_id"));
                f.setInterviewId(rs.getInt("interview_id"));
                f.setFeedback(rs.getString("feedback"));
                f.setResult(rs.getString("result"));

                list.add(f);
            }
        }

        return list;
    }
}
