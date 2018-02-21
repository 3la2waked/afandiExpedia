package com.expedia.beans;

/**
 * Represents offers. For now, only hotel offers are supported
 *
 * @author Alaa Fandi waked75@gmail.com
 * @since 2018/02/21
 */
public class Offers {
    private Hotel[] hotels;

    public Hotel[] getHotels() {
        return hotels;
    }

    public void setHotels(Hotel[] hotels) {
        this.hotels = hotels;
    }
}
