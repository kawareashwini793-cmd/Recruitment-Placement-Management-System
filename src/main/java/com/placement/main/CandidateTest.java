
package com.placement.main;

import com.placement.model.Candidate;
import com.placement.service.CandidateService;

import java.util.Scanner;

public class CandidateTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CandidateService service = new CandidateService();

        try {
            System.out.println("===== CANDIDATE REGISTRATION =====");

            System.out.print("Enter Full Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Phone: ");
            String phone = sc.nextLine();

            System.out.print("Enter Qualification: ");
            String qualification = sc.nextLine();

            System.out.print("Enter Passing Year: ");
            int year = Integer.parseInt(sc.nextLine());

            Candidate candidate = new Candidate(
                    0, name, email, phone, qualification, year
            );

            boolean result = service.registerCandidate(candidate);

            if (result) {
                System.out.println("Candidate Registered Successfully!");
            } else {
                System.out.println("Registration Failed!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
