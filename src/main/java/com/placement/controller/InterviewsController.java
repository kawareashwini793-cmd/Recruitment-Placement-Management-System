
package com.placement.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/interviews")
public class InterviewsController {

    private final JdbcTemplate jdbcTemplate;

    public InterviewsController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public List<Map<String, Object>> getAllInterviews() {

        String sql = """
                SELECT interview_id, application_id, interview_round,
                       interview_date, interview_status
                FROM interviews
                ORDER BY interview_id
                """;

        return jdbcTemplate.queryForList(sql);
    }
}
