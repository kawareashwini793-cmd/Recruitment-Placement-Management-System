
package com.placement.main;

import com.placement.service.ShortlistingService;
import java.util.Scanner;

public class ShortlistingTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ShortlistingService service = new ShortlistingService();

        try {
            System.out.println("===== CANDIDATE SHORTLISTING =====");

            System.out.print("Enter Application ID: ");
            int applicationId = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Status (SHORTLISTED/REJECTED/SELECTED): ");
            String status = sc.nextLine().trim();

            boolean result =
                    service.updateApplicationStatus(applicationId, status);

            if (result) {
                System.out.println("Application Status Updated Successfully!");
            } else {
                System.out.println("Application Not Found!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
