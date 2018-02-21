package com.expedia.beans;

/**
 * Represents the pricing information for a single hotel
 *
 * @author Alaa Fandi waked75@gmail.com
 * @since 2018/02/21
 */
public class HotelPricing {

    private float averagePriceValue,
            totalPriceValue,
            crossOutPriceValue,
            originalPricePerNight,
            percentSaving;

    private String currency;

    private boolean drr;

    public float getAveragePriceValue() {
        return averagePriceValue;
    }

    public void setAveragePriceValue(float averagePriceValue) {
        this.averagePriceValue = averagePriceValue;
    }

    public float getTotalPriceValue() {
        return totalPriceValue;
    }

    public void setTotalPriceValue(float totalPriceValue) {
        this.totalPriceValue = totalPriceValue;
    }

    public float getCrossOutPriceValue() {
        return crossOutPriceValue;
    }

    public void setCrossOutPriceValue(float crossOutPriceValue) {
        this.crossOutPriceValue = crossOutPriceValue;
    }

    public float getOriginalPricePerNight() {
        return originalPricePerNight;
    }

    public void setOriginalPricePerNight(float originalPricePerNight) {
        this.originalPricePerNight = originalPricePerNight;
    }

    public float getPercentSaving() {
        return percentSaving;
    }

    public void setPercentSaving(float percentSaving) {
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
