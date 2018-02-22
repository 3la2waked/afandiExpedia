package com.expedia.beans;

/**
 * Holds a single search result data
 *
 * @author Alaa Fandi waked75@gmail.com
 */
public class SearchResult {

    private OfferInfo offerInfo;
    private UserInfo userInfo;
    private Offers offers;
    private int errorCode;
    private String errorMessage;

    public OfferInfo getOfferInfo() {
        return offerInfo;
    }

    public void setOfferInfo(OfferInfo offerInfo) {
        this.offerInfo = offerInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Offers getOffers() {
        return offers;
    }

    public void setOffers(Offers offers) {
        this.offers = offers;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
