
package com.placement.service;

import com.placement.dao.OfferDAO;
import com.placement.model.Offer;

import java.sql.SQLException;
import java.util.List;

public class OfferService {

    private final OfferDAO offerDAO = new OfferDAO();

    public boolean createOffer(Offer offer) throws SQLException {

        if (offer == null) {
            throw new IllegalArgumentException(
                    "Offer cannot be null.");
        }

        if (offer.getApplicationId() <= 0) {
            throw new IllegalArgumentException(
                    "Valid Application ID is required.");
        }

        if (offer.getOfferedSalary() == null
                || offer.getOfferedSalary().signum() <= 0) {
            throw new IllegalArgumentException(
                    "Offered salary must be greater than zero.");
        }

        if (offer.getOfferDate() == null) {
            throw new IllegalArgumentException(
                    "Offer date is required.");
        }

        if (offer.getOfferStatus() == null
                || !offer.getOfferStatus().trim().matches(
                        "(?i)PENDING|ACCEPTED|REJECTED")) {
            throw new IllegalArgumentException(
                    "Status must be PENDING, ACCEPTED or REJECTED.");
        }

        offer.setOfferStatus(
                offer.getOfferStatus().trim().toUpperCase());

        return offerDAO.addOffer(offer);
    }

    public List<Offer> getAllOffers() throws SQLException {
        return offerDAO.getAllOffers();
    }
}
