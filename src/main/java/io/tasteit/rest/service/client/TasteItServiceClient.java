package io.tasteit.rest.service.client;

import io.tasteit.rest.service.model.AuthenticationToken;
import io.tasteit.rest.service.model.Cuisine;
import io.tasteit.rest.service.model.exception.TasteItClientException;
import io.tasteit.rest.service.model.exception.TasteItServiceException;
import io.tasteit.rest.service.model.request.DeletePromotionImageRequest;
import io.tasteit.rest.service.model.request.GenerateTokenRequest;
import io.tasteit.rest.service.model.request.GetCuisineRequest;
import io.tasteit.rest.service.model.request.GetRestaurantRequest;
import io.tasteit.rest.service.model.request.UploadPromotionImageRequest;
import io.tasteit.rest.service.model.request.ResetCustomerRequest;
import io.tasteit.rest.service.model.request.RevokeTokenRequest;
import io.tasteit.rest.service.model.request.UpdateCuisineRequest;
import io.tasteit.rest.service.model.request.UpdatePromotionImageDisplayOrderRequest;
import io.tasteit.rest.service.model.request.UpdateRestaurantDetailRequest;
import io.tasteit.rest.service.model.request.UpdateRestaurantInfoRequest;
import io.tasteit.rest.service.model.request.UpdateRestaurantOpenHoursRequest;
import io.tasteit.rest.service.model.response.GenerateTokenResponse;
import io.tasteit.rest.service.model.response.GetRestaurantMenuResponse;
import io.tasteit.rest.service.model.response.GetRestaurantResponse;

public interface TasteItServiceClient {

    //TODO: Add JavaDoc
    
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
     * @param token
     * @return GetRestaurantResponse
     * @throws TasteItClientException
     * @throws TasteItServiceException
     */
    public GetRestaurantResponse getRestaurant(GetRestaurantRequest request, AuthenticationToken token) 
            throws TasteItClientException, TasteItServiceException;
    
    /**
     * Get restaurant menu
     * @param request
     * @param token
     * @return GetRestaurantMenuResponse
     * @throws TasteItClientException
     * @throws TasteItServiceException
     */
    public GetRestaurantMenuResponse getRestaurantMenu(GetRestaurantRequest request, AuthenticationToken token)
            throws TasteItClientException, TasteItServiceException;

    /**
     * Get cuisine
     * @param request
     * @param token
     * @return GetCuisineResponse
     * @throws TasteItClientException
     * @throws TasteItServiceException
     */
    public Cuisine getCuisine(GetCuisineRequest request, AuthenticationToken token) 
            throws TasteItClientException, TasteItServiceException;
    
    
    /**
     * update restaurant info
     * @param request
     * @param token
     * @throws TasteItClientException
     * @throws TasteItServiceException
     */
    public void updateRestaurantInfo(UpdateRestaurantInfoRequest request, AuthenticationToken token)
            throws TasteItClientException, TasteItServiceException;
    
    /**
     * update restaurant detail
     * @param request
     * @param token
     * @throws TasteItClientException
     * @throws TasteItServiceException
     */
    public void updateRestaurantDetail(UpdateRestaurantDetailRequest request, AuthenticationToken token)
            throws TasteItClientException, TasteItServiceException;

    /**
     * update restaurant open hours
     * @param request
     * @param token
     * @throws TasteItClientException
     * @throws TasteItServiceException
     */
    public void updateRestaurantOpenHours(UpdateRestaurantOpenHoursRequest request, AuthenticationToken token)
            throws TasteItClientException, TasteItServiceException;

    /**
     * update cuisine
     * @param request
     * @param token
     * @throws TasteItClientException
     * @throws TasteItServiceException
     */
    public void updateCuisine(UpdateCuisineRequest request, AuthenticationToken token)
            throws TasteItClientException, TasteItServiceException;

    /**
     * reset customer credential
     * @param request
     * @throws TasteItClientException
     * @throws TasteItServiceException
     */
    public void resetCustomerCredential(ResetCustomerRequest request)
            throws TasteItClientException, TasteItServiceException;
    
    /**
     * upload promotion image to server
     * @param request
     * @param token
     * @throws TasteItClientException
     * @throws TasteItServiceException
     */
    public void addPromotionImage(UploadPromotionImageRequest request, AuthenticationToken token)
            throws TasteItClientException, TasteItServiceException;

    /**
     * delete promotion image
     * @param request
     * @param token
     * @throws TasteItClientException
     * @throws TasteItServiceException
     */
    public void deletePromotionImage(DeletePromotionImageRequest request, AuthenticationToken token)
            throws TasteItClientException, TasteItServiceException;
    

    /**
     * update promotion image display order
     * @param request
     * @param token
     * @throws TasteItClientException
     * @throws TasteItServiceException
     */
    public void updatePromotionImageDisplayOrder(UpdatePromotionImageDisplayOrderRequest request, AuthenticationToken token)
            throws TasteItClientException, TasteItServiceException;
    
    public void shutdown();
}
