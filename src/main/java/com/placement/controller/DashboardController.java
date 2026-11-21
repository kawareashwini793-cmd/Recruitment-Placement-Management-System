
package com.placement.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final JdbcTemplate jdbcTemplate;

    public DashboardController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/stats")
    public Map<String, Integer> getDashboardStats() {

        Map<String, Integer> stats = new LinkedHashMap<>();

        stats.put("totalStudents",
                jdbcTemplate.queryForObject(
                        "SELECT COUNT(*) FROM candidates", Integer.class));

        stats.put("totalCompanies",
                jdbcTemplate.queryForObject(
                        "SELECT COUNT(*) FROM companies", Integer.class));

        stats.put("totalJobs",
                jdbcTemplate.queryForObject(
                        "SELECT COUNT(*) FROM jobs", Integer.class));

        stats.put("totalPlacements",
                jdbcTemplate.queryForObject(
                        "SELECT COUNT(*) FROM placements", Integer.class));

        return stats;
    }
}
