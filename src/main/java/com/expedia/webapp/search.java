package com.expedia.webapp;

import com.expedia.api.Deals;
import com.expedia.beans.SearchResult;
import com.expedia.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "search")
public class search extends HttpServlet {

    /**
     * Displays search page and handles filter form submission.
     * Passes {@link SearchResult} object with last search result
     * @param request Servlet request
     * @param response Servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> params = new HashMap<>();

        if (request.getParameter("search") != null) {
            String destinationName = request.getParameter("destinationName");
            String minTripStartDate = request.getParameter("minTripStartDate");
            String maxTripStartDate = request.getParameter("maxTripStartDate");
            String minStarRating = request.getParameter("minStarRating");
            String maxStarRating = request.getParameter("maxStarRating");
            String minTotalRate = request.getParameter("minTotalRate");
            String maxTotalRate = request.getParameter("maxTotalRate");
            String minGuestRating = request.getParameter("minGuestRating");
            String maxGuestRating = request.getParameter("maxGuestRating");
            String lengthOfStay = request.getParameter("lengthOfStay");
            String rooms = request.getParameter("rooms");

            if(!StringUtils.isNullOrEmpty(destinationName)) {
                params.put("destinationName", destinationName);
            }
            if(!StringUtils.isNullOrEmpty(minTripStartDate)) {
                params.put("minTripStartDate", minTripStartDate);
            }
            if(!StringUtils.isNullOrEmpty(maxTripStartDate)) {
                params.put("maxTripStartDate", maxTripStartDate);
            }
            if(!StringUtils.isNullOrEmpty(minStarRating)) {
                params.put("minStarRating", minStarRating);
            }
            if(!StringUtils.isNullOrEmpty(maxStarRating)) {
                params.put("maxStarRating", maxStarRating);
            }
            if(!StringUtils.isNullOrEmpty(minTotalRate)) {
                params.put("minTotalRate", minTotalRate);
            }
            if(!StringUtils.isNullOrEmpty(maxTotalRate)) {
                params.put("maxTotalRate", maxTotalRate);
            }
            if(!StringUtils.isNullOrEmpty(minGuestRating)) {
                params.put("minGuestRating", minGuestRating);
            }
            if(!StringUtils.isNullOrEmpty(maxGuestRating)) {
                params.put("maxGuestRating", maxGuestRating);
            }
            if(!StringUtils.isNullOrEmpty(lengthOfStay)) {
                params.put("lengthOfStay", lengthOfStay);
            }
            if(!StringUtils.isNullOrEmpty(rooms)) {
                params.put("rooms", rooms);
            }
        }

        SearchResult searchResult = Deals.GetSearchResult(params);
        request.setAttribute("searchResult", searchResult);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
