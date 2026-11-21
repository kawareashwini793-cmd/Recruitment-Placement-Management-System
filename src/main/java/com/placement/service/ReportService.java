
package com.placement.service;

import com.placement.dao.ReportDAO;
import java.sql.SQLException;

public class ReportService {

    private final ReportDAO reportDAO = new ReportDAO();

    public void showPlacementReport() throws SQLException {
        reportDAO.generatePlacementReport();
    }
}
