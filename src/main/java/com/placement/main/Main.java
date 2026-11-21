
package com.placement.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("\n========================================");
            System.out.println(" RECRUITMENT & PLACEMENT MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Candidate Management");
            System.out.println("2. Company Management");
            System.out.println("3. Job Management");
            System.out.println("4. Application Management");
            System.out.println("5. Interview Management");
            System.out.println("6. Interview Feedback");
            System.out.println("7. Eligibility Check");
            System.out.println("8. Shortlisting");
            System.out.println("9. Offer Management");
            System.out.println("10. Placement Management");
            System.out.println("11. Placement Reports");
            System.out.println("0. Exit");
            System.out.println("========================================");

            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            try {
                switch (choice) {

                    case 1:
                        CandidateTest.main(new String[0]);
                        break;

                    case 2:
                        CompanyTest.main(new String[0]);
                        break;

                    case 3:
                        JobTest.main(new String[0]);
                        break;

                    case 4:
                        ApplicationTest.main(new String[0]);
                        break;

                    case 5:
                        InterviewTest.main(new String[0]);
                        break;

                    case 6:
                        InterviewFeedbackTest.main(new String[0]);
                        break;

                    case 7:
                        EligibilityTest.main(new String[0]);
                        break;

                    case 8:
                        ShortlistingTest.main(new String[0]);
                        break;

                    case 9:
                        OfferTest.main(new String[0]);
                        break;

                    case 10:
                        PlacementTest.main(new String[0]);
                        break;

                    case 11:
                        ReportTest.main(new String[0]);
                        break;

                    case 0:
                        System.out.println("Thank you for using the system!");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 0);

        sc.close();
    }
}
