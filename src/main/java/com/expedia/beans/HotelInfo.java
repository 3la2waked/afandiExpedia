package com.expedia.beans;

/**
 * Detailed information for a single hotel
 *
 * @author Alaa Fandi waked75@gmail.com
 * @since 2018/02/21
 */
public class HotelInfo {

    private String id,
            name,
            localizedName,
            destination,
            destinationRegionId,
            longDestination,
            streetAddress,
            city,
            province,
            countryCode,
            imageUrl,
            starRating;

    private float latitude,
            longitude,
            guestReviewRating;

    private int reviewTotal;

    private boolean vipAccess,
            isOfficialRating;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestinationRegionId() {
        return destinationRegionId;
    }

    public void setDestinationRegionId(String destinationRegionId) {
        this.destinationRegionId = destinationRegionId;
    }

    public String getLongDestination() {
        return longDestination;
    }

    public void setLongDestination(String longDestination) {
        this.longDestination = longDestination;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStarRating() {
        return starRating;
    }

    public void setStarRating(String starRating) {
        this.starRating = starRating;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getGuestReviewRating() {
        return guestReviewRating;
    }

    public void setGuestReviewRating(float guestReviewRating) {
        this.guestReviewRating = guestReviewRating;
    }

    public int getReviewTotal() {
        return reviewTotal;
    }

    public void setReviewTotal(int reviewTotal) {
        this.reviewTotal = reviewTotal;
    }

    public boolean isVipAccess() {
        return vipAccess;
    }

    public void setVipAccess(boolean vipAccess) {
        this.vipAccess = vipAccess;
    }

    public boolean isOfficialRating() {
        return isOfficialRating;
    }

    public void setOfficialRating(boolean officialRating) {
        isOfficialRating = officialRating;
    }
}
