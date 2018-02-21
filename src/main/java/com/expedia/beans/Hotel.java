package com.expedia.beans;

/**
 * Represents a single hotel
 *
 * @author Alaa Fandi waked75@gmail.com
 * @since 2018/02/21
 */
public class Hotel {
    private OfferDateRange offerDateRange;
    private Destination destination;
    private HotelInfo info;
    private HotelPricing pricing;
    private HotelUrls urls;

    public OfferDateRange getOfferDateRange() {
        return offerDateRange;
    }

    public void setOfferDateRange(OfferDateRange offerDateRange) {
        this.offerDateRange = offerDateRange;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public HotelInfo getInfo() {
        return info;
    }

    public void setInfo(HotelInfo info) {
        this.info = info;
    }

    public HotelPricing getPricing() {
        return pricing;
    }

    public void setPricing(HotelPricing pricing) {
        this.pricing = pricing;
    }

    public HotelUrls getUrls() {
        return urls;
    }

    public void setUrls(HotelUrls urls) {
        this.urls = urls;
    }
}
