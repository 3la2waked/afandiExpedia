package com.expedia.beans;

/**
 * Represents an offer info
 *
 * @author Alaa Fandi waked75@gmail.com
 */
public class OfferInfo {

    private String siteId,
            language,
            currency,
            userSelectedCurrency;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getUserSelectedCurrency() {
        return userSelectedCurrency;
    }

    public void setUserSelectedCurrency(String userSelectedCurrency) {
        this.userSelectedCurrency = userSelectedCurrency;
    }
}
