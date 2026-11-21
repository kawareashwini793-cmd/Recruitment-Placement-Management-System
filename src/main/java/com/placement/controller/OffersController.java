
package com.placement.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/offers")
public class OffersController {

    private final JdbcTemplate jdbcTemplate;

    public OffersController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public List<Map<String, Object>> getAllOffers() {

        String sql = """
                SELECT offer_id, application_id, offered_salary,
                       offer_date, offer_status
                FROM offers
                ORDER BY offer_id
                """;

        return jdbcTemplate.queryForList(sql);
    }
}
