package com.expedia.beans;

/**
 * Represents the pricing information for a single hotel
 *
 * @author Alaa Fandi waked75@gmail.com
 * @since 2018/02/21
 */
public class HotelPricing {

    private double averagePriceValue,
            totalPriceValue,
            crossOutPriceValue,
            originalPricePerNight,
            percentSaving;

    private String currency;

    private boolean drr;

    public double getAveragePriceValue() {
        return averagePriceValue;
    }

    public void setAveragePriceValue(double averagePriceValue) {
        this.averagePriceValue = averagePriceValue;
    }

    public double getTotalPriceValue() {
        return totalPriceValue;
    }

    public void setTotalPriceValue(double totalPriceValue) {
        this.totalPriceValue = totalPriceValue;
    }

    public double getCrossOutPriceValue() {
        return crossOutPriceValue;
    }

    public void setCrossOutPriceValue(double crossOutPriceValue) {
        this.crossOutPriceValue = crossOutPriceValue;
    }

    public double getOriginalPricePerNight() {
        return originalPricePerNight;
    }

    public void setOriginalPricePerNight(double originalPricePerNight) {
        this.originalPricePerNight = originalPricePerNight;
    }

    public double getPercentSaving() {
        return percentSaving;
    }

    public void setPercentSaving(double percentSaving) {
        this.percentSaving = percentSaving;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isDrr() {
        return drr;
    }

    public void setDrr(boolean drr) {
        this.drr = drr;
    }
}
