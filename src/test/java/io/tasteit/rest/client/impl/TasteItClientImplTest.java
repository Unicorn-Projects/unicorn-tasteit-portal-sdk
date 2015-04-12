package io.tasteit.rest.client.impl;

import io.tasteit.rest.service.client.impl.TasteItServiceClientImpl;
import io.tasteit.rest.service.model.exception.AccessDeniedException;
import io.tasteit.rest.service.model.exception.InvalidRequestException;
import io.tasteit.rest.service.model.request.GenerateTokenRequest;
import io.tasteit.rest.service.model.request.GetRestaurantRequest;
import io.tasteit.rest.service.model.response.GenerateTokenResponse;

import org.junit.BeforeClass;
import org.junit.Test;

public class TasteItClientImplTest {
    private static TasteItServiceClientImpl client;
    private static GenerateTokenResponse token;
    @BeforeClass
    public static void setup() {
        client = new TasteItServiceClientImpl("https://api-gamma.tasteit.io", 443);
        token = client.generateAccessToken(new GenerateTokenRequest("test@tasteit.io", "password123456"));
    }
    
    @Test
    public void testGetRestaurantDetailHappyCase() {
        client.getRestaurant(new GetRestaurantRequest("c23n-83440033214612255"), token);
    }
    
    @Test(expected = AccessDeniedException.class)
    public void testGetRestaurantDetailWithBadRequestOne() {
        client.getRestaurant(new GetRestaurantRequest("c23n-83442342344312"), token);
    }
    
    @Test(expected = InvalidRequestException.class)
    public void testGetRestaurantDetailWithBadRequestTwo() {
        client.getRestaurant(new GetRestaurantRequest("c23n-83440033214612255qwq"), token);
    }
    
}
