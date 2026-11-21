
package com.placement.main;

import com.placement.service.ReportService;

public class ReportTest {

    public static void main(String[] args) {

        try {
            ReportService service = new ReportService();

            service.showPlacementReport();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
