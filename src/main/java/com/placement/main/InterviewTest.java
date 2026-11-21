
package com.placement.main;

import com.placement.model.Interview;
import com.placement.service.InterviewService;

import java.sql.Timestamp;
import java.util.Scanner;

public class InterviewTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InterviewService service = new InterviewService();

        try {
            System.out.println("===== INTERVIEW SCHEDULING =====");

            System.out.print("Enter Application ID: ");
            int applicationId = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Interview Round: ");
            String round = sc.nextLine();

            System.out.print("Enter Interview Date (yyyy-mm-dd hh:mm:ss): ");
            String date = sc.nextLine();

            Timestamp interviewDate = Timestamp.valueOf(date);

            Interview interview = new Interview(
                    applicationId,
                    round,
                    interviewDate,
                    "SCHEDULED"
            );

            boolean result = service.scheduleInterview(interview);

            if (result) {
                System.out.println("Interview Scheduled Successfully!");
            } else {
                System.out.println("Interview Scheduling Failed!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}

