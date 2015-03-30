package io.tasteit.rest.client.impl;

import io.tasteit.rest.activities.exception.BadRequestException;
import io.tasteit.rest.activities.model.request.RestaurantRequest;

import org.junit.Test;

public class TasteItClientImplTest {
    
    @Test
    public void testGetRestaurantDetailHappyCase() {
        TasteItClientImpl client = TasteItClientImpl.get();
        client.getRestaurantDetail(new RestaurantRequest("c22y-71863204526927392"));
    }
    
    @Test(expected = BadRequestException.class)
    public void testGetRestaurantDetailWithBadRequest() {
        TasteItClientImpl client = TasteItClientImpl.get();
        client.getRestaurantDetail(new RestaurantRequest("c23n-8344003321461225"));
    }
}
