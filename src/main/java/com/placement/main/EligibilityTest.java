
package com.placement.main;

import com.placement.service.EligibilityService;
import java.util.Scanner;

public class EligibilityTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EligibilityService service = new EligibilityService();

        try {
            System.out.println("===== CANDIDATE ELIGIBILITY CHECK =====");

            System.out.print("Enter Candidate ID: ");
            int candidateId = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Job ID: ");
            int jobId = Integer.parseInt(sc.nextLine());

            boolean eligible =
                    service.checkEligibility(candidateId, jobId);

            if (eligible) {
                System.out.println("Congratulations! Candidate is Eligible.");
            } else {
                System.out.println("Sorry! Candidate is Not Eligible.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
