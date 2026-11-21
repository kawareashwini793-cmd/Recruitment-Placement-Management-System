
package com.placement.service;

import com.placement.dao.CompanyDAO;
import com.placement.model.Company;

import java.sql.SQLException;
import java.util.List;

public class CompanyService {

    private final CompanyDAO companyDAO = new CompanyDAO();

    public boolean registerCompany(Company company) throws SQLException {

        if (company == null) {
            throw new IllegalArgumentException("Company cannot be null.");
        }

        if (company.getCompanyName() == null
                || company.getCompanyName().isBlank()) {
            throw new IllegalArgumentException("Company name is required.");
        }

        if (company.getContactEmail() != null
                && !company.getContactEmail().isBlank()
                && !company.getContactEmail().matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Enter a valid contact email.");
        }

        return companyDAO.addCompany(company);
    }

    public List<Company> getAllCompanies() throws SQLException {
        return companyDAO.getAllCompanies();
    }
}
