package com.expedia.beans;

import java.util.Date;

/**
 * Represents the offer date range for a single hotel
 *
 * @author Alaa Fandi waked75@gmail.com
 * @since 2018/02/21
 */
public class OfferDateRange {

    private Date travelStartDate,
            travelEndDate;
    private int lengthOfStay;

    public Date getTravelStartDate() {
        return travelStartDate;
    }

    public void setTravelStartDate(Date travelStartDate) {
        this.travelStartDate = travelStartDate;
    }

    public Date getTravelEndDate() {
        return travelEndDate;
    }

    public void setTravelEndDate(Date travelEndDate) {
        this.travelEndDate = travelEndDate;
    }

    public int getLengthOfStay() {
        return lengthOfStay;
    }

    public void setLengthOfStay(int lengthOfStay) {
        this.lengthOfStay = lengthOfStay;
    }
}
