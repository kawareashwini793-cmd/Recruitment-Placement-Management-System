
package com.placement.main;

import com.placement.model.Job;
import com.placement.service.JobService;

import java.math.BigDecimal;
import java.util.Scanner;

public class JobTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        JobService service = new JobService();

        try {
            System.out.println("===== JOB REGISTRATION =====");

            System.out.print("Enter Company ID: ");
            int companyId = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Job Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Job Description: ");
            String description = sc.nextLine();

            System.out.print("Enter Minimum Percentage: ");
            BigDecimal percentage =
                    new BigDecimal(sc.nextLine());

            System.out.print("Enter Passing Year: ");
            int year = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Maximum Backlogs: ");
            int backlogs = Integer.parseInt(sc.nextLine());

            Job job = new Job(
                    companyId,
                    title,
                    description,
                    percentage,
                    year,
                    backlogs
            );

            boolean result = service.addJob(job);

            if (result) {
                System.out.println("Job Added Successfully!");
            } else {
                System.out.println("Job Registration Failed!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
