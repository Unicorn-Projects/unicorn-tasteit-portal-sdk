package io.tasteit.rest.client;

import io.tasteit.rest.activities.exception.BadRequestException;
import io.tasteit.rest.activities.exception.InternalServerErrorException;
import io.tasteit.rest.activities.model.RestaurantDetail;
import io.tasteit.rest.activities.model.request.RestaurantRequest;

public interface TasteItClient {

    /**
     * Get restaurant detail
     * @param request
     * @return
     * @throws BadRequestException if request is invalid
     * @throws InternalServerErrorException internal server error
     */
    public RestaurantDetail getRestaurantDetail(RestaurantRequest request) 
            throws BadRequestException, InternalServerErrorException;
    
}
