
package com.placement.dao;

import com.placement.model.Company;
import com.placement.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO {

    public boolean addCompany(Company company) throws SQLException {

        String sql = "INSERT INTO companies "
                + "(company_name, location, website, contact_email) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, company.getCompanyName());
            ps.setString(2, company.getLocation());
            ps.setString(3, company.getWebsite());
            ps.setString(4, company.getContactEmail());

            return ps.executeUpdate() > 0;
        }
    }

    public List<Company> getAllCompanies() throws SQLException {

        List<Company> companies = new ArrayList<>();

        String sql = "SELECT company_id, company_name, location, "
                + "website, contact_email FROM companies";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Company company = new Company();

                company.setCompanyId(rs.getInt("company_id"));
                company.setCompanyName(rs.getString("company_name"));
                company.setLocation(rs.getString("location"));
                company.setWebsite(rs.getString("website"));
                company.setContactEmail(rs.getString("contact_email"));

                companies.add(company);
            }
        }

        return companies;
    }
}
