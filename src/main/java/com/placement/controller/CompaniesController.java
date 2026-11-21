package com.placement.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/companies")
public class CompaniesController {

    private final JdbcTemplate jdbcTemplate;

    public CompaniesController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public List<Map<String, Object>> getAllCompanies() {
        String sql = """
                SELECT company_id, company_name, location,
                       website, contact_email
                FROM companies
                ORDER BY company_id
                """;

        return jdbcTemplate.queryForList(sql);
    }
}