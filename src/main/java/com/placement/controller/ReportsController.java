
package com.placement.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportsController {

    private final JdbcTemplate jdbcTemplate;

    public ReportsController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public List<Map<String, Object>> getPlacementReport() {

        String sql = """
            SELECT
                c.full_name AS candidate_name,
                co.company_name,
                j.job_title,
                p.joining_date,
                p.joining_status
            FROM placements p
            JOIN candidates c ON p.candidate_id = c.candidate_id
            JOIN companies co ON p.company_id = co.company_id
            JOIN jobs j ON p.job_id = j.job_id
            ORDER BY p.placement_id
            """;

        return jdbcTemplate.queryForList(sql);
    }
}
