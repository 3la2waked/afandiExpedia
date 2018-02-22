<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <title>Search Hotel Deals</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap-theme.min.css" />

        <script type="text/javascript" src="/resources/jquery/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="/resources/bootstrap/js/bootstrap.min.js"></script>
    </head>

    <body>
        <div class="container" style="padding-top: 20px;">
            <div class="row">
                <div class="col-xs-12">
                    <form class="" method="get">
                        <div class="form-group col-xs-4">
                            <label for="destinationName"><i class="glyphicon glyphicon-pushpin"></i> Destination Name</label>
                            <input type="text" class="form-control" id="destinationName" name="destinationName" placeholder="City, airport, landmark, hotel name or address">
                        </div>
                        <div class="form-group col-xs-4">
                            <label for="minTripStartDate"><i class="glyphicon glyphicon-calendar"></i> Check In</label>
                            <input type="date" class="form-control" id="minTripStartDate" name="minTripStartDate">
                        </div>
                        <div class="form-group col-xs-4">
                            <label for="maxTripStartDate"><i class="glyphicon glyphicon-calendar"></i> Check Out</label>
                            <input type="date" class="form-control" id="maxTripStartDate" name="maxTripStartDate">
                        </div>
                        <div class="form-group col-xs-3">
                            <label for="minStarRating"><i class="glyphicon glyphicon-star-empty"></i> Min Star Rating</label>
                            <select class="form-control" id="minStarRating" name="minStarRating">
                                <option value="">Select min star rating</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select>
                        </div>
                        <div class="form-group col-xs-3">
                            <label for="maxStarRating"><i class="glyphicon glyphicon-star-empty"></i> Max Star Rating</label>
                            <select class="form-control" id="maxStarRating" name="maxStarRating">
                                <option value="">Select max star rating</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select>
                        </div>
                        <div class="form-group col-xs-3">
                            <label for="minTotalRate">Min Total Rate</label>
                            <input type="number" class="form-control" id="minTotalRate" name="minTotalRate">
                        </div>
                        <div class="form-group col-xs-3">
                            <label for="maxTotalRate">Max Total Rate</label>
                            <input type="number" class="form-control" id="maxTotalRate" name="maxTotalRate">
                        </div>
                        <div class="form-group col-xs-3">
                            <label for="minGuestRating"><i class="glyphicon glyphicon-star-empty"></i> Min Guest Rating</label>
                            <select class="form-control" id="minGuestRating" name="minGuestRating">
                                <option value="">Select min guest rating</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select>
                        </div>
                        <div class="form-group col-xs-3">
                            <label for="maxGuestRating"><i class="glyphicon glyphicon-star-empty"></i> Max Guest Rating</label>
                            <select class="form-control" id="maxGuestRating" name="maxGuestRating">
                                <option value="">Select max guest rating</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select>
                        </div>
                        <div class="form-group col-xs-3">
                            <label for="lengthOfStay">Length Of Stay</label>
                            <input type="number" class="form-control" id="lengthOfStay" name="lengthOfStay">
                        </div>
                        <div class="form-group col-xs-3">
                            <label for="rooms"><i class="glyphicon glyphicon-bed"></i> Romes</label>
                            <input type="number" class="form-control" id="rooms" name="rooms">
                        </div>
                        <div class="form-group col-xs-12">
                            <input type="submit" name="search" value="Search" class="btn btn-primary" />
                        </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <c:choose>
                        <c:when test="${searchResult.errorCode != 0}">
                            <c:if test="${searchResult.errorMessage != null}">
                                <div class="alert alert-danger" role="alert">
                                    ${searchResult.errorMessage}
                                </div>
                            </c:if>
                        </c:when>
                        <c:otherwise>
                            <h3>Search result:</h3>
                            <c:choose>
                                <c:when test="${searchResult.offers != null && searchResult.offers.hotels != null}">
                                    <h4>${fn:length(searchResult.offers.hotels)} results found!</h4>

                                    <div class="row">
                                        <c:forEach items="${searchResult.offers.hotels}" var="hotel">
                                            <div class="col-xs-12">
                                                <div class="well well-sm">
                                                    <div class="media">
                                                        <div class="media-left">
                                                            <a href="#">
                                                                <img class="media-object" src="${hotel.info.imageUrl}" alt="${hotel.info.name}">
                                                            </a>
                                                        </div>
                                                        <div class="media-body">
                                                            <div class="row">
                                                                <div class="col-xs-6">
                                                                    <h4 class="media-heading">
                                                                        <a href="${hotel.urls.infoSite}">${hotel.info.name}</a>
                                                                    </h4>
                                                                    <p>
                                                                        <small><i class="glyphicon glyphicon-pushpin"></i> ${hotel.info.longDestination}</small>
                                                                    </p>
                                                                    <p>
                                                                        <span class="label label-success">${hotel.info.starRating}</span> <small>(${hotel.info.reviewTotal})</small>
                                                                    </p>
                                                                </div>
                                                                <div class="col-xs-6 text-right">
                                                                    <p>
                                                                        <i class="glyphicon glyphicon-star-empty"></i> ${hotel.info.guestReviewRating} <span class="text-muted">/ 5</span>
                                                                    </p>
                                                                    <p class="lead">
                                                                        ${hotel.pricing.averagePriceValue} <span class="text-muted">${hotel.pricing.currency}</span>
                                                                    </p>
                                                                    <p>
                                                                        Save up to ${hotel.pricing.percentSaving} <span class="text-muted">%</span>
                                                                    </p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <h4>Your search returned zero results!</h4>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </body>
</html>
