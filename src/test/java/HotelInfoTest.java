import com.expedia.beans.HotelInfo;
import org.junit.Test;
import static org.junit.Assert.*;

public class HotelInfoTest {

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

        assertEquals("2803824", hotelInfo.getId());
        assertEquals("Siegel Slots and Suites", hotelInfo.getName());
        assertEquals("Siegel Slots and Suites", hotelInfo.getLocalizedName());
        assertEquals("Las Vegas", hotelInfo.getDestination());
        assertEquals("2008", hotelInfo.getDestinationRegionId());
        assertEquals("Las Vegas,NV,USA", hotelInfo.getLongDestination());
        assertEquals("Las Vegas", hotelInfo.getCity());
        assertEquals("NV", hotelInfo.getProvince());
        assertEquals("USA", hotelInfo.getCountryCode());
        assertEquals(36.240642, hotelInfo.getLatitude(), 0.001);
        assertEquals(-115.058771, hotelInfo.getLongitude(), 0.001);
        assertEquals("2.5", hotelInfo.getStarRating());
        assertEquals(2.07, hotelInfo.getGuestReviewRating(), 0.001);
        assertEquals(225, hotelInfo.getReviewTotal());
        assertEquals("https://images.trvl-media.com/hotels/3000000/2810000/2803900/2803824/0a151c48_t.jpg", hotelInfo.getImageUrl());
        assertEquals(false, hotelInfo.isVipAccess());
        assertEquals(false, hotelInfo.isOfficialRating());

    }

}
