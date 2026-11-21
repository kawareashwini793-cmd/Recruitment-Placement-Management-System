
package com.placement.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/placements")
public class PlacementsController {

    private final JdbcTemplate jdbcTemplate;

    public PlacementsController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public List<Map<String, Object>> getPlacements() {

        String sql = "SELECT * FROM placements ORDER BY placement_id";

        return jdbcTemplate.queryForList(sql);
    }
}
