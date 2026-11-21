
package com.placement.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {

    private final JdbcTemplate jdbcTemplate;

    public JobsController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public List<Map<String, Object>> getAllJobs() {

        String sql = """
                SELECT job_id, company_id, job_title, job_description,
                       minimum_percentage, passing_year
                FROM jobs
                ORDER BY job_id
                """;

        return jdbcTemplate.queryForList(sql);
    }
}
