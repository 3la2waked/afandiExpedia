package com.expedia.beans;

/**
 * Represents the destination for a single hotel
 *
 * @author Alaa Fandi waked75@gmail.com
 * @since 2018/02/21
 */
public class Destination {

    private String regionID,
            associatedMultiCityRegionId,
            longName,
            shortName,
            country,
            province,
            city,
            tla,
            nonLocalizedCity;

    public String getRegionID() {
        return regionID;
    }

    public void setRegionID(String regionID) {
        this.regionID = regionID;
    }

    public String getAssociatedMultiCityRegionId() {
        return associatedMultiCityRegionId;
    }

    public void setAssociatedMultiCityRegionId(String associatedMultiCityRegionId) {
        this.associatedMultiCityRegionId = associatedMultiCityRegionId;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTla() {
        return tla;
    }

    public void setTla(String tla) {
        this.tla = tla;
    }

    public String getNonLocalizedCity() {
        return nonLocalizedCity;
    }

    public void setNonLocalizedCity(String nonLocalizedCity) {
        this.nonLocalizedCity = nonLocalizedCity;
    }
}
