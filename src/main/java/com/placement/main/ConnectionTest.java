
package com.placement.main;

import com.placement.utility.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionTest {

    public static void main(String[] args) {

        System.out.println("Connecting to MySQL...");

        try (
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                "SELECT DATABASE(), VERSION()"
            )
        ) {

            System.out.println("Connection Successful!");

            if (rs.next()) {
                System.out.println(
                    "Database Name: " + rs.getString(1)
                );

                System.out.println(
                    "MySQL Version: " + rs.getString(2)
                );
            }

        } catch (Exception e) {
            System.out.println("Connection Failed!");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
