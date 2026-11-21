
package com.placement.main;

import com.placement.model.Offer;
import com.placement.service.OfferService;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Scanner;

public class OfferTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        OfferService service = new OfferService();

        try {
            System.out.println("===== OFFER MANAGEMENT =====");

            System.out.print("Enter Application ID: ");
            int applicationId = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Offered Salary: ");
            BigDecimal salary = new BigDecimal(sc.nextLine().trim());

            System.out.print("Enter Offer Date (yyyy-mm-dd): ");
            Date date = Date.valueOf(sc.nextLine().trim());

            System.out.print("Enter Offer Status (PENDING/ACCEPTED/REJECTED): ");
            String status = sc.nextLine().trim();

            Offer offer = new Offer(
                    applicationId, salary, date, status);

            boolean result = service.createOffer(offer);

            if (result) {
                System.out.println("Offer Created Successfully!");
            } else {
                System.out.println("Offer Creation Failed!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
