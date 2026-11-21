
package com.placement.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/applications")
public class ApplicationsController {

    private final JdbcTemplate jdbcTemplate;

    public ApplicationsController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public List<Map<String, Object>> getAllApplications() {

        String sql = """
                SELECT application_id, candidate_id, job_id,
                       application_date, application_status
                FROM applications
                ORDER BY application_id
                """;

        return jdbcTemplate.queryForList(sql);
    }
}
