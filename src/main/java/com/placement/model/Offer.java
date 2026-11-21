
package com.placement.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Offer {

    private int offerId;
    private int applicationId;
    private BigDecimal offeredSalary;
    private Date offerDate;
    private String offerStatus;

    public Offer() {
    }

    public Offer(int applicationId, BigDecimal offeredSalary,
                 Date offerDate, String offerStatus) {
        this.applicationId = applicationId;
        this.offeredSalary = offeredSalary;
        this.offerDate = offerDate;
        this.offerStatus = offerStatus;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public BigDecimal getOfferedSalary() {
        return offeredSalary;
    }

    public void setOfferedSalary(BigDecimal offeredSalary) {
        this.offeredSalary = offeredSalary;
    }

    public Date getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(Date offerDate) {
        this.offerDate = offerDate;
    }

    public String getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(String offerStatus) {
        this.offerStatus = offerStatus;
    }
}
