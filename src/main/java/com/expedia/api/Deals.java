package com.expedia.api;

import com.expedia.beans.*;
import com.expedia.utils.StringUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

/**
 * <h1>Deals API</h1>
 * Reads a JSON response for hotel deals
 * from a JSON API and fetch the data
 * retrieved into the proper bean
 *
 * @author Alaa Fandi waked75@gmail.com
 * @version 1.0
 */
public class Deals {

    /**
     * Hotel deals JSON API URL
     */
    public static final String API_URL = "https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel";

    /**
     * Get the {@link SearchResult} of a single hit to
     * the hotel deals API. If a certain query parameter
     * were provided, the result will be filtered out
     * based on the provided parameters
     *
     * @param params additional filters
     * @return {@link SearchResult} object
     */
    public static SearchResult GetSearchResult(Map<String, Object> params) {
        SearchResult searchResult = new SearchResult();
        String url = API_URL;

        if(!params.isEmpty()) {
            Iterator iterator = params.entrySet().iterator();
            URIBuilder uriBuilder = null;

            try {
                uriBuilder = new URIBuilder(url);

                while (iterator.hasNext()) {
                    Map.Entry paramKeyValue = (Map.Entry) iterator.next();
                    uriBuilder.addParameter(paramKeyValue.getKey().toString(), paramKeyValue.getValue().toString());
                }

                url = uriBuilder.toString();
            }
            catch (URISyntaxException e) {
                // url is not in a valid http pattern
                e.printStackTrace();
            }
        }

        try {
            JSONObject jsonSearchResult = GetJSONFromUrl(url);
            if(jsonSearchResult != null) {
                FetchJSONIntoSearchResult(searchResult, jsonSearchResult);
            }
        }
        catch (IOException e) {
            // IOException occurred
            e.printStackTrace();
        }

        return searchResult;
    }

    /**
     * This method is used to get JSON
     * response from a JSON API, then return
     * it as {@link JSONObject}
     *
     * @param url of the JSON API
     * @return {@link JSONObject}
     * @throws IOException if an error occurred while reading through IO stream channel
     */
    protected static JSONObject GetJSONFromUrl(String url) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("accept", "application/json");

        HttpResponse httpResponse = httpClient.execute(httpGet);

        String json = IOUtils.toString(httpResponse.getEntity().getContent());

        return !StringUtils.isNullOrEmpty(json) ? new JSONObject(json) : null;
    }

    /**
     * Fetches data of a {@link JSONObject} into
     * {@link SearchResult} object.
     *
     * In case something went wrong, only the
     * error code and message will be fetched,
     * everything else will be ignored.
     *
     * @param searchResult object to fetch data inside
     * @param jsonSearchResult JSON object which retrieved from the JSON API
     */
    protected static void FetchJSONIntoSearchResult(SearchResult searchResult, JSONObject jsonSearchResult) {
        if(jsonSearchResult != null) {
            if(jsonSearchResult.has(JSONKeys.KEY_OFFER_ERROR_INFO)) {
                JSONObject offerErrorInfoJSON = jsonSearchResult.getJSONObject(JSONKeys.KEY_OFFER_ERROR_INFO);
                if(offerErrorInfoJSON.has(JSONKeys.KEY_ERROR_CODE)) {
                    searchResult.setErrorCode(offerErrorInfoJSON.getInt(JSONKeys.KEY_ERROR_CODE));
                }
                if(offerErrorInfoJSON.has(JSONKeys.KEY_ERROR_MESSAGE)) {
                    searchResult.setErrorMessage(offerErrorInfoJSON.getString(JSONKeys.KEY_ERROR_MESSAGE));
                }
            }
            else {
                searchResult.setOfferInfo(GetOfferInfoFromJSON(jsonSearchResult));
                searchResult.setUserInfo(GetUserInfoFromJSON(jsonSearchResult));
                searchResult.setOffers(GetOffersFromJSON(jsonSearchResult));
            }
        }
    }

    /**
     * Retrieves an {@link OfferInfo} object
     * after filling it with the data of offer
     * info JSON object.
     *
     * @param json {@link JSONObject} of the offer info data
     * @return {@link OfferInfo} object, null if @param json is null or has no data
     */
    private static OfferInfo GetOfferInfoFromJSON(JSONObject json) {
        if(json.has(JSONKeys.KEY_OFFER_INFO)) {
            JSONObject offerInfoJSON = json.getJSONObject(JSONKeys.KEY_OFFER_INFO);
            OfferInfo offerInfo = new OfferInfo();

            if(offerInfoJSON != null) {
                if(offerInfoJSON.has(JSONKeys.KEY_SITE_ID)) {
                    offerInfo.setSiteId(offerInfoJSON.getString(JSONKeys.KEY_SITE_ID));
                }
                if(offerInfoJSON.has(JSONKeys.KEY_LANGUAGE)) {
                    offerInfo.setLanguage(offerInfoJSON.getString(JSONKeys.KEY_LANGUAGE));
                }
                if(offerInfoJSON.has(JSONKeys.KEY_CURRENCY)) {
                    offerInfo.setCurrency(offerInfoJSON.getString(JSONKeys.KEY_CURRENCY));
                }
                if(offerInfoJSON.has(JSONKeys.KEY_USER_SELECTED_CURRENCY)) {
                    offerInfo.setUserSelectedCurrency(offerInfoJSON.getString(JSONKeys.KEY_USER_SELECTED_CURRENCY));
                }
            }
            return offerInfo;
        }
        return null;
    }

    /**
     * Retrieves an {@link UserInfo} object
     * after filling it with the data of user
     * info JSON object.
     *
     * @param json {@link JSONObject} of the user info data
     * @return {@link UserInfo} object, null if @param json is null or has no data
     */
    private static UserInfo GetUserInfoFromJSON(JSONObject json) {
        if(json.has(JSONKeys.KEY_USER_INFO)) {
            JSONObject userInfoJSON = json.getJSONObject(JSONKeys.KEY_USER_INFO);
            UserInfo userInfo = new UserInfo();

            if(userInfoJSON != null) {
                if(userInfoJSON.has(JSONKeys.KEY_PERSONA)) {
                    JSONObject personaJSON = userInfoJSON.getJSONObject(JSONKeys.KEY_PERSONA);
                    Persona persona = new Persona();
                    if(personaJSON.has(JSONKeys.KEY_PERSONA_TYPE)) {
                        persona.setPersonaType(personaJSON.getString(JSONKeys.KEY_PERSONA_TYPE));
                    }
                    userInfo.setPersona(persona);
                }
                if(userInfoJSON.has(JSONKeys.KEY_USER_ID)) {
                    userInfo.setUserId(userInfoJSON.getString(JSONKeys.KEY_USER_ID));
                }
            }
            return userInfo;
        }
        return null;
    }

    /**
     * Retrieves an {@link Offers} object
     * after filling it with the data of
     * offers JSON object.
     *
     * @param json {@link JSONObject} of the offers data
     * @return {@link Offers} object, null if @param json is null or has no data
     */
    private static Offers GetOffersFromJSON(JSONObject json) {
        if(json.has(JSONKeys.KEY_OFFERS)) {
            JSONObject offersJSON = json.getJSONObject(JSONKeys.KEY_OFFERS);
            Offers offers = new Offers();

            if(offersJSON != null) {
                offers.setHotels(GetHotelsArrayFromJSON(offersJSON));
            }
            return offers;
        }
        return null;
    }

    /**
     * Retrieves an array of {@link Hotel} objects
     * after filling it with the data of
     * hotels JSON array.
     *
     * @param json {@link JSONObject} of the offers data
     * @return array of {@link Hotel} objects, null if @param json is null or has no data
     */
    private static Hotel[] GetHotelsArrayFromJSON(JSONObject json) {
        if(json.has(JSONKeys.KEY_HOTEL)) {
            JSONArray hotelsJSON = json.getJSONArray(JSONKeys.KEY_HOTEL);
            if(hotelsJSON != null && hotelsJSON.length() > 0) {
                ArrayList<Hotel> hotels = new ArrayList<>();
                for (int i = 0; i < hotelsJSON.length(); i++) {
                    JSONObject hotelJSON = (JSONObject) hotelsJSON.get(i);
                    if(hotelJSON != null) {
                        Hotel hotel = new Hotel();
                        hotel.setOfferDateRange(GetHotelOfferDateRangeFromJSON(hotelJSON));
                        hotel.setDestination(GetDestinationFromJSON(hotelJSON));
                        hotel.setInfo(GetHotelInfoFromJSON(hotelJSON));
                        hotel.setPricing(GetHotelPricingFromJSON(hotelJSON));
                        hotel.setUrls(GetHotelUrlsFromJSON(hotelJSON));

                        hotels.add(hotel);
                    }
                }
                return hotels.toArray(new Hotel[hotels.size()]);
            }
        }
        return null;
    }

    /**
     * Retrieves an {@link OfferDateRange} object
     * after filling it with the data of
     * a single hotel JSON object.
     *
     * @param json {@link JSONObject} of a given hotel data
     * @return {@link OfferDateRange} object, null if @param json is null or has no data
     */
    private static OfferDateRange GetHotelOfferDateRangeFromJSON(JSONObject json) {
        if(json.has(JSONKeys.KEY_OFFER_DATE_RANGE)) {
            JSONObject offerDateRangeJSON = json.getJSONObject(JSONKeys.KEY_OFFER_DATE_RANGE);
            OfferDateRange offerDateRange = new OfferDateRange();

            if(offerDateRangeJSON != null) {
                if(offerDateRangeJSON.has(JSONKeys.KEY_TRAVEL_START_DATE)) {
                    JSONArray startDateJSON = offerDateRangeJSON.getJSONArray(JSONKeys.KEY_TRAVEL_START_DATE);
                    if(startDateJSON != null && startDateJSON.length() == 3) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.YEAR, startDateJSON.getInt(0));
                        calendar.set(Calendar.MONTH, startDateJSON.getInt(1));
                        calendar.set(Calendar.DAY_OF_MONTH, startDateJSON.getInt(2));

                        offerDateRange.setTravelStartDate(calendar.getTime());
                    }
                }
                if(offerDateRangeJSON.has(JSONKeys.KEY_TRAVEL_END_DATE)) {
                    JSONArray endDateJSON = offerDateRangeJSON.getJSONArray(JSONKeys.KEY_TRAVEL_END_DATE);
                    if(endDateJSON != null && endDateJSON.length() == 3) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.YEAR, endDateJSON.getInt(0));
                        calendar.set(Calendar.MONTH, endDateJSON.getInt(1));
                        calendar.set(Calendar.DAY_OF_MONTH, endDateJSON.getInt(2));

                        offerDateRange.setTravelEndDate(calendar.getTime());
                    }
                }
                if(offerDateRangeJSON.has(JSONKeys.KEY_LENGTH_OF_STAY)) {
                    offerDateRange.setLengthOfStay(offerDateRangeJSON.getInt(JSONKeys.KEY_LENGTH_OF_STAY));
                }
            }
            return offerDateRange;
        }
        return null;
    }

    /**
     * Retrieves a {@link Destination} object
     * after filling it with the data of
     * a single hotel JSON object.
     *
     * @param json {@link JSONObject} of a given hotel data
     * @return {@link Destination} object, null if @param json is null or has no data
     */
    private static Destination GetDestinationFromJSON(JSONObject json) {
        if(json.has(JSONKeys.KEY_DESTINATION)) {
            JSONObject destinationJSON = json.getJSONObject(JSONKeys.KEY_DESTINATION);
            Destination destination = new Destination();

            if(destinationJSON != null) {
                if(destinationJSON.has(JSONKeys.KEY_REGION_ID)) {
                    destination.setRegionID(destinationJSON.getString(JSONKeys.KEY_REGION_ID));
                }
                if(destinationJSON.has(JSONKeys.KEY_ASSOCIATED_MULTI_CITY_REGION_ID)) {
                    destination.setAssociatedMultiCityRegionId(destinationJSON.getString(JSONKeys.KEY_ASSOCIATED_MULTI_CITY_REGION_ID));
                }
                if(destinationJSON.has(JSONKeys.KEY_LONG_NAME)) {
                    destination.setLongName(destinationJSON.getString(JSONKeys.KEY_LONG_NAME));
                }
                if(destinationJSON.has(JSONKeys.KEY_SHORT_NAME)) {
                    destination.setShortName(destinationJSON.getString(JSONKeys.KEY_SHORT_NAME));
                }
                if(destinationJSON.has(JSONKeys.KEY_COUNTRY)) {
                    destination.setCountry(destinationJSON.getString(JSONKeys.KEY_COUNTRY));
                }
                if(destinationJSON.has(JSONKeys.KEY_PROVINCE)) {
                    destination.setProvince(destinationJSON.getString(JSONKeys.KEY_PROVINCE));
                }
                if(destinationJSON.has(JSONKeys.KEY_CITY)) {
                    destination.setCity(destinationJSON.getString(JSONKeys.KEY_CITY));
                }
                if(destinationJSON.has(JSONKeys.KEY_TLA)) {
                    destination.setTla(destinationJSON.getString(JSONKeys.KEY_TLA));
                }
                if(destinationJSON.has(JSONKeys.KEY_NONE_LOCALIZED_CITY)) {
                    destination.setNonLocalizedCity(destinationJSON.getString(JSONKeys.KEY_NONE_LOCALIZED_CITY));
                }
            }
            return destination;
        }
        return null;
    }

    /**
     * Retrieves a {@link HotelInfo} object
     * after filling it with the data of
     * a single hotel JSON object.
     *
     * @param json {@link JSONObject} of a given hotel data
     * @return {@link HotelInfo} object, null if @param json is null or has no data
     */
    private static HotelInfo GetHotelInfoFromJSON(JSONObject json) {
        if(json.has(JSONKeys.KEY_HOTEL_INFO)) {
            JSONObject hotelInfoJSON = json.getJSONObject(JSONKeys.KEY_HOTEL_INFO);
            HotelInfo hotelInfo = new HotelInfo();

            if(hotelInfoJSON != null) {
                if(hotelInfoJSON.has(JSONKeys.KEY_HOTEL_ID)) {
                    hotelInfo.setId(hotelInfoJSON.getString(JSONKeys.KEY_HOTEL_ID));
                }
                if(hotelInfoJSON.has(JSONKeys.KEY_HOTEL_NAME)) {
                    hotelInfo.setName(hotelInfoJSON.getString(JSONKeys.KEY_HOTEL_NAME));
                }
                if(hotelInfoJSON.has(JSONKeys.KEY_LOCALIZED_HOTEL_NAME)) {
                    hotelInfo.setLocalizedName(hotelInfoJSON.getString(JSONKeys.KEY_LOCALIZED_HOTEL_NAME));
                }
                if(hotelInfoJSON.has(JSONKeys.KEY_HOTEL_DESTINATION)) {
                    hotelInfo.setDestination(hotelInfoJSON.getString(JSONKeys.KEY_HOTEL_DESTINATION));
                }
                if(hotelInfoJSON.has(JSONKeys.KEY_HOTEL_DESTINATION_REGION_ID)) {
                    hotelInfo.setDestinationRegionId(hotelInfoJSON.getString(JSONKeys.KEY_HOTEL_DESTINATION_REGION_ID));
                }
                if(hotelInfoJSON.has(JSONKeys.KEY_HOTEL_LONG_DESTINATION)) {
                    hotelInfo.setLongDestination(hotelInfoJSON.getString(JSONKeys.KEY_HOTEL_LONG_DESTINATION));
                }
                if(hotelInfoJSON.has(JSONKeys.KEY_HOTEL_STREET_ADDRESS)) {
                    hotelInfo.setStreetAddress(hotelInfoJSON.getString(JSONKeys.KEY_HOTEL_STREET_ADDRESS));
                }
                if(hotelInfoJSON.has(JSONKeys.KEY_HOTEL_CITY)) {
                    hotelInfo.setCity(hotelInfoJSON.getString(JSONKeys.KEY_HOTEL_CITY));
                }
                if(hotelInfoJSON.has(JSONKeys.KEY_HOTEL_PROVINCE)) {
                    hotelInfo.setProvince(hotelInfoJSON.getString(JSONKeys.KEY_HOTEL_PROVINCE));
                }
                if(hotelInfoJSON.has(JSONKeys.KEY_HOTEL_COUNTRY_CODE)) {
                    hotelInfo.setCountryCode(hotelInfoJSON.getString(JSONKeys.KEY_HOTEL_COUNTRY_CODE));
                }
                if(hotelInfoJSON.has(JSONKeys.KEY_HOTEL_LATITUDE)) {
                    hotelInfo.setLatitude(hotelInfoJSON.getDouble(JSONKeys.KEY_HOTEL_LATITUDE));
                }
                if(hotelInfoJSON.has(JSONKeys.KEY_HOTEL_LONGITUDE)) {
                    hotelInfo.setLongitude(hotelInfoJSON.getDouble(JSONKeys.KEY_HOTEL_LONGITUDE));
                }
                if(hotelInfoJSON.has(JSONKeys.KEY_HOTEL_STAR_RATING)) {
                    hotelInfo.setStarRating(hotelInfoJSON.getString(JSONKeys.KEY_HOTEL_STAR_RATING));
                }
                if(hotelInfoJSON.has(JSONKeys.KEY_HOTEL_GUEST_REVIEW_RATING)) {
                    hotelInfo.setGuestReviewRating(hotelInfoJSON.getDouble(JSONKeys.KEY_HOTEL_GUEST_REVIEW_RATING));
                }
                if(hotelInfoJSON.has(JSONKeys.KEY_HOTEL_REVIEW_TOTAL)) {
                    hotelInfo.setReviewTotal(hotelInfoJSON.getInt(JSONKeys.KEY_HOTEL_REVIEW_TOTAL));
                }
                if(hotelInfoJSON.has(JSONKeys.KEY_HOTEL_IMAGE_URL)) {
                    hotelInfo.setImageUrl(hotelInfoJSON.getString(JSONKeys.KEY_HOTEL_IMAGE_URL));
                }
                if(hotelInfoJSON.has(JSONKeys.KEY_VIP_ACCESS)) {
                    hotelInfo.setVipAccess(hotelInfoJSON.getBoolean(JSONKeys.KEY_VIP_ACCESS));
                }
                if(hotelInfoJSON.has(JSONKeys.KEY_IS_OFFICIAL_RATING)) {
                    hotelInfo.setOfficialRating(hotelInfoJSON.getBoolean(JSONKeys.KEY_IS_OFFICIAL_RATING));
                }
            }
            return hotelInfo;
        }
        return null;
    }

    /**
     * Retrieves a {@link HotelPricing} object
     * after filling it with the data of
     * a single hotel JSON object.
     *
     * @param json {@link JSONObject} of a given hotel data
     * @return {@link HotelPricing} object, null if @param json is null or has no data
     */
    private static HotelPricing GetHotelPricingFromJSON(JSONObject json) {
        if(json.has(JSONKeys.KEY_HOTEL_PRICE_INFO)) {
            JSONObject pricingInfoJSON = json.getJSONObject(JSONKeys.KEY_HOTEL_PRICE_INFO);
            HotelPricing hotelPricing = new HotelPricing();

            if(pricingInfoJSON != null) {
                if(pricingInfoJSON.has(JSONKeys.KEY_AVERAGE_PRICE_VALUE)) {
                    hotelPricing.setAveragePriceValue(pricingInfoJSON.getDouble(JSONKeys.KEY_AVERAGE_PRICE_VALUE));
                }
                if(pricingInfoJSON.has(JSONKeys.KEY_TOTAL_PRICE_VALUE)) {
                    hotelPricing.setTotalPriceValue(pricingInfoJSON.getDouble(JSONKeys.KEY_TOTAL_PRICE_VALUE));
                }
                if(pricingInfoJSON.has(JSONKeys.KEY_CROSS_OUT_PRICE_VALUE)) {
                    hotelPricing.setCrossOutPriceValue(pricingInfoJSON.getDouble(JSONKeys.KEY_CROSS_OUT_PRICE_VALUE));
                }
                if(pricingInfoJSON.has(JSONKeys.KEY_ORIGINAL_PRICE_PER_NIGHT)) {
                    hotelPricing.setOriginalPricePerNight(pricingInfoJSON.getDouble(JSONKeys.KEY_ORIGINAL_PRICE_PER_NIGHT));
                }
                if(pricingInfoJSON.has(JSONKeys.KEY_PRICING_CURRENCY)) {
                    hotelPricing.setCurrency(pricingInfoJSON.getString(JSONKeys.KEY_PRICING_CURRENCY));
                }
                if(pricingInfoJSON.has(JSONKeys.KEY_PERCENT_SAVINGS)) {
                    hotelPricing.setPercentSaving(pricingInfoJSON.getDouble(JSONKeys.KEY_PERCENT_SAVINGS));
                }
                if(pricingInfoJSON.has(JSONKeys.KEY_DRR)) {
                    hotelPricing.setDrr(pricingInfoJSON.getBoolean(JSONKeys.KEY_DRR));
                }
            }
            return hotelPricing;
        }
        return null;
    }

    /**
     * Retrieves a {@link HotelUrls} object
     * after filling it with the data of
     * a single hotel JSON object.
     *
     * @param json {@link JSONObject} of a given hotel data
     * @return {@link HotelUrls} object, null if @param json is null or has no data
     */
    private static HotelUrls GetHotelUrlsFromJSON(JSONObject json) {
        if(json.has(JSONKeys.KEY_HOTEL_URLS)) {
            JSONObject urlsJSON = json.getJSONObject(JSONKeys.KEY_HOTEL_URLS);
            HotelUrls hotelUrls = new HotelUrls();

            if(urlsJSON != null) {
                if(urlsJSON.has(JSONKeys.KEY_HOTEL_INFO_SITE_URL)) {
                    hotelUrls.setInfoSite(urlsJSON.getString(JSONKeys.KEY_HOTEL_INFO_SITE_URL));
                }
                if(urlsJSON.has(JSONKeys.KEY_HOTEL_SEARCH_RESULT_URL)) {
                    hotelUrls.setSearchResult(urlsJSON.getString(JSONKeys.KEY_HOTEL_SEARCH_RESULT_URL));
                }
            }
            return hotelUrls;
        }
        return null;
    }
}
