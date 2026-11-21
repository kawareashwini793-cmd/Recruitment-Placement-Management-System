
package com.placement.main;

import com.placement.model.Company;
import com.placement.service.CompanyService;

import java.util.Scanner;

public class CompanyTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CompanyService service = new CompanyService();

        try {
            System.out.println("===== COMPANY REGISTRATION =====");

            System.out.print("Enter Company Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Location: ");
            String location = sc.nextLine();

            System.out.print("Enter Website: ");
            String website = sc.nextLine();

            System.out.print("Enter Contact Email: ");
            String email = sc.nextLine();

            Company company = new Company(
                    name, location, website, email
            );

            boolean result = service.registerCompany(company);

            if (result) {
                System.out.println("Company Registered Successfully!");
            } else {
                System.out.println("Registration Failed!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
