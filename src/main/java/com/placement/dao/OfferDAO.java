
package com.placement.dao;

import com.placement.model.Offer;
import com.placement.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OfferDAO {

    public boolean addOffer(Offer offer) throws SQLException {

        String sql = "INSERT INTO offers "
                + "(application_id, offered_salary, offer_date, offer_status) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, offer.getApplicationId());
            ps.setBigDecimal(2, offer.getOfferedSalary());
            ps.setDate(3, offer.getOfferDate());
            ps.setString(4, offer.getOfferStatus());

            return ps.executeUpdate() > 0;
        }
    }

    public List<Offer> getAllOffers() throws SQLException {

        List<Offer> offers = new ArrayList<>();

        String sql = "SELECT offer_id, application_id, offered_salary, "
                + "offer_date, offer_status FROM offers";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Offer offer = new Offer();

                offer.setOfferId(rs.getInt("offer_id"));
                offer.setApplicationId(rs.getInt("application_id"));
                offer.setOfferedSalary(rs.getBigDecimal("offered_salary"));
                offer.setOfferDate(rs.getDate("offer_date"));
                offer.setOfferStatus(rs.getString("offer_status"));

                offers.add(offer);
            }
        }

        return offers;
    }
}
