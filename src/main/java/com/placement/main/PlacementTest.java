
package com.placement.main;

import com.placement.model.Placement;
import com.placement.service.PlacementService;

import java.sql.Date;
import java.util.Scanner;

public class PlacementTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PlacementService service = new PlacementService();

        try {
            System.out.println("===== PLACEMENT MANAGEMENT =====");

            System.out.print("Enter Candidate ID: ");
            int candidateId = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Enter Company ID: ");
            int companyId = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Enter Job ID: ");
            int jobId = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Enter Joining Date (yyyy-mm-dd): ");
            Date joiningDate = Date.valueOf(sc.nextLine().trim());

            System.out.print("Enter Joining Status (OFFERED/ACCEPTED/JOINED/NOT JOINED): ");
            String status = sc.nextLine().trim();

            Placement placement = new Placement(
                    candidateId, companyId, jobId, joiningDate, status);

            boolean result = service.createPlacement(placement);

            if (result) {
                System.out.println("Placement Created Successfully!");
            } else {
                System.out.println("Placement Creation Failed!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
