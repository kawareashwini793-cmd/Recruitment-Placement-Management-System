
package com.placement.main;

import com.placement.model.Application;
import com.placement.service.ApplicationService;

import java.util.Scanner;

public class ApplicationTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ApplicationService service = new ApplicationService();

        try {
            System.out.println("===== JOB APPLICATION =====");

            System.out.print("Enter Candidate ID: ");
            int candidateId = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Job ID: ");
            int jobId = Integer.parseInt(sc.nextLine());

            Application application = new Application(
                    candidateId,
                    jobId,
                    "APPLIED"
            );

            boolean result = service.applyForJob(application);

            if (result) {
                System.out.println("Job Application Submitted Successfully!");
            } else {
                System.out.println("Job Application Failed!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
