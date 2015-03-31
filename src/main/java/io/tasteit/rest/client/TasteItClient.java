package io.tasteit.rest.client;

import io.tasteit.rest.service.model.exception.TasteItClientException;
import io.tasteit.rest.service.model.exception.TasteItServiceException;
import io.tasteit.rest.service.model.request.GenerateTokenRequest;
import io.tasteit.rest.service.model.request.GetRestaurantRequest;
import io.tasteit.rest.service.model.request.RevokeTokenRequest;
import io.tasteit.rest.service.model.response.GenerateTokenResponse;
import io.tasteit.rest.service.model.response.GetRestaurantMenuResponse;
import io.tasteit.rest.service.model.response.GetRestaurantResponse;

public interface TasteItClient {

    
    /**
     * Generate access token, this is used for sign in
     * @param request
     * @return GenerateTokenResponse
     * @throws TasteItClientException
     * @throws TasteItServiceException
     */
    public GenerateTokenResponse generateAccessToken(GenerateTokenRequest request) 
            throws TasteItClientException, TasteItServiceException;
    
    /**
     * Revoke access token, this is used for sign out
     * @param request
     * @return GenerateTokenResponse
     * @throws TasteItClientException
     * @throws TasteItServiceException
     */
    public void revokeAccessToken(RevokeTokenRequest request) 
            throws TasteItClientException, TasteItServiceException;
    
    /**
     * Get restaurant
     * @param request
     * @return GetRestaurantResponse
     * @throws TasteItClientException
     * @throws TasteItServiceException
     */
    public GetRestaurantResponse getRestaurant(GetRestaurantRequest request) 
            throws TasteItClientException, TasteItServiceException;
    
    /**
     * Get restaurant menu
     * @param request
     * @return GetRestaurantMenuResponse
     * @throws TasteItClientException
     * @throws TasteItServiceException
     */
    public GetRestaurantMenuResponse getRestaurantMenu(GetRestaurantRequest request)
            throws TasteItClientException, TasteItServiceException;
        
}
