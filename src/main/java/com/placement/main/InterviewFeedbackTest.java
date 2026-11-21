
package com.placement.main;

import com.placement.model.InterviewFeedback;
import com.placement.service.InterviewFeedbackService;

import java.util.Scanner;

public class InterviewFeedbackTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InterviewFeedbackService service =
                new InterviewFeedbackService();

        try {
            System.out.println("===== INTERVIEW FEEDBACK =====");

            System.out.print("Enter Interview ID: ");
            int interviewId = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Feedback: ");
            String feedback = sc.nextLine();

            System.out.print("Enter Result (SELECTED/REJECTED/ON HOLD): ");
            String result = sc.nextLine();

            InterviewFeedback f =
                    new InterviewFeedback(interviewId, feedback, result);

            boolean saved = service.addFeedback(f);

            if (saved) {
                System.out.println("Interview Feedback Saved Successfully!");
            } else {
                System.out.println("Feedback Saving Failed!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
