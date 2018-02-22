import com.expedia.beans.Hotel;
import com.expedia.beans.HotelInfo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelTest {
    @Test
    public void test() {
        HotelInfo hotelInfo = new HotelInfo();
        hotelInfo.setId("2803824");
        hotelInfo.setName("Siegel Slots and Suites");
        hotelInfo.setLocalizedName("Siegel Slots and Suites");
        hotelInfo.setDestination("Las Vegas");
        hotelInfo.setDestinationRegionId("2008");
        hotelInfo.setLongDestination("Las Vegas,NV,USA");
        hotelInfo.setCity("Las Vegas");
        hotelInfo.setProvince("NV");
        hotelInfo.setCountryCode("USA");
        hotelInfo.setLatitude(36.240642);
        hotelInfo.setLongitude(-115.058771);
        hotelInfo.setStarRating("2.5");
        hotelInfo.setGuestReviewRating(2.07);
        hotelInfo.setReviewTotal(225);
        hotelInfo.setImageUrl("https://images.trvl-media.com/hotels/3000000/2810000/2803900/2803824/0a151c48_t.jpg");
        hotelInfo.setVipAccess(false);
        hotelInfo.setOfficialRating(false);

        Hotel hotel = new Hotel();
        hotel.setInfo(hotelInfo);

        assertEquals(hotelInfo.getId(), hotel.getInfo().getId());
        assertEquals(hotelInfo.getName(), hotel.getInfo().getName());
        assertEquals(hotelInfo.getLocalizedName(), hotel.getInfo().getLocalizedName());
        assertEquals(hotelInfo.getDestination(), hotel.getInfo().getDestination());
        assertEquals(hotelInfo.getDestinationRegionId(), hotel.getInfo().getDestinationRegionId());
        assertEquals(hotelInfo.getLongDestination(), hotel.getInfo().getLongDestination());
        assertEquals(hotelInfo.getCity(), hotel.getInfo().getCity());
        assertEquals(hotelInfo.getProvince(), hotel.getInfo().getProvince());
        assertEquals(hotelInfo.getCountryCode(), hotel.getInfo().getCountryCode());
        assertEquals(hotelInfo.getLatitude(), hotel.getInfo().getLatitude(), 0.001);
        assertEquals(hotelInfo.getLongitude(), hotel.getInfo().getLongitude(), 0.001);
        assertEquals(hotelInfo.getStarRating(), hotel.getInfo().getStarRating());
        assertEquals(hotelInfo.getGuestReviewRating(), hotel.getInfo().getGuestReviewRating(), 0.001);
        assertEquals(hotelInfo.getReviewTotal(), hotel.getInfo().getReviewTotal());
        assertEquals(hotelInfo.getImageUrl(), hotel.getInfo().getImageUrl());
        assertEquals(hotelInfo.isVipAccess(), hotel.getInfo().isVipAccess());
        assertEquals(hotelInfo.isOfficialRating(), hotel.getInfo().isOfficialRating());

    }
}
