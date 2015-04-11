package io.tasteit.rest.client.impl;

import io.tasteit.rest.service.model.exception.TasteItClientException;
import io.tasteit.rest.service.model.exception.TasteItServiceException;
import io.tasteit.rest.service.model.request.GenerateTokenRequest;
import io.tasteit.rest.service.model.request.GetRestaurantRequest;
import io.tasteit.rest.service.model.request.RevokeTokenRequest;
import io.tasteit.rest.service.model.response.GenerateTokenResponse;
import io.tasteit.rest.service.model.response.GetRestaurantMenuResponse;
import io.tasteit.rest.service.model.response.GetRestaurantResponse;

public class Example {
    
    public static void main(String[] args) {
        TasteItClientImpl client = new TasteItClientImpl("https://api-gamma.tasteit.io", 443);
       
        GenerateTokenResponse token = client.generateAccessToken(new GenerateTokenRequest("test@tasteit.io", "password123456"));
        System.out.println(token);
        
        try {
            GetRestaurantResponse restaurant = client.getRestaurant(new GetRestaurantRequest("c23n-83440033214612255"), token);
            System.out.println(restaurant);
            
            GetRestaurantMenuResponse restaurantMenu = client.getRestaurantMenu(new GetRestaurantRequest("c23n-83440033214612255"), token);
            System.out.println(restaurantMenu);
            
        } catch (TasteItClientException error) {
            System.out.println(error);
        } catch (TasteItServiceException error) {
            System.out.println(error);
        } finally {
            client.revokeAccessToken(new RevokeTokenRequest(token.getTokenType(), token.getAccessToken(), token.getPrincipal()));
        }
        System.exit(0);
    }
}
