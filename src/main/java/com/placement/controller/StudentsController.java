
package com.placement.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentsController {

    private final JdbcTemplate jdbcTemplate;

    public StudentsController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // GET - View all students
    @GetMapping
    public List<Map<String, Object>> getAllStudents() {

        String sql = """
                SELECT candidate_id, full_name, email, phone,
                       qualification, passing_year, percentage, backlogs
                FROM candidates
                ORDER BY candidate_id
                """;

        return jdbcTemplate.queryForList(sql);
    }

    // POST - Add student
    @PostMapping
    public String addStudent(@RequestBody Map<String, Object> data) {

        String sql = """
                INSERT INTO candidates
                (full_name, email, phone, qualification,
                 passing_year, percentage, backlogs)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        jdbcTemplate.update(sql,
                data.get("full_name"),
                data.get("email"),
                data.get("phone"),
                data.get("qualification"),
                data.get("passing_year"),
                data.get("percentage"),
                data.get("backlogs"));

        return "Student added successfully!";
    }

    // PUT - Update student
    @PutMapping("/{id}")
    public String updateStudent(
            @PathVariable("id") int id,
            @RequestBody Map<String, Object> data) {

        String sql = """
                UPDATE candidates
                SET full_name = ?, email = ?, phone = ?,
                    qualification = ?, passing_year = ?,
                    percentage = ?, backlogs = ?
                WHERE candidate_id = ?
                """;

        int rows = jdbcTemplate.update(sql,
                data.get("full_name"),
                data.get("email"),
                data.get("phone"),
                data.get("qualification"),
                data.get("passing_year"),
                data.get("percentage"),
                data.get("backlogs"),
                id);

        return rows > 0 ? "Student updated successfully!" : "Student not found!";
    }

    // DELETE - Delete student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") int id) {

        int rows = jdbcTemplate.update(
                "DELETE FROM candidates WHERE candidate_id = ?", id);

        return rows > 0 ? "Student deleted successfully!" : "Student not found!";
    }
}

