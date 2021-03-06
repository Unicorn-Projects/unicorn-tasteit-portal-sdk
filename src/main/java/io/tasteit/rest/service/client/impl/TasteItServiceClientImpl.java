package io.tasteit.rest.service.client.impl;

import io.tasteit.rest.service.client.TasteItServiceClient;
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

import java.util.Base64;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.client.Invocation.Builder;

import jersey.repackaged.com.google.common.collect.ImmutableMap;

import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.grizzly.connector.GrizzlyConnectorProvider;

public class TasteItServiceClientImpl implements TasteItServiceClient {

    private final Client client;
    private final WebTarget webTarget;

    public TasteItServiceClientImpl(String baseUrl, Integer port) {
        try {
            if (StringUtils.isBlank(baseUrl) || port == null) {
                throw new IllegalArgumentException("baseUrl and port should not be null or empty");
            }
            ClientConfig clientConfig = new ClientConfig().connectorProvider(new GrizzlyConnectorProvider());
            clientConfig.register(JSONObjectMapperImpl.class);
            this.client = ClientBuilder.newBuilder().withConfig(clientConfig).build();
            // milliseconds
            this.client.property(ClientProperties.CONNECT_TIMEOUT, 60000);
            this.client.property(ClientProperties.READ_TIMEOUT, 60000);
            this.webTarget = client.target(UriBuilder.fromUri(baseUrl).port(port).build());
        } catch (Exception error) {
            throw new RuntimeException("Failed while attempting to initialize TasteItClient", error);
        }
    }

    private Builder authenticateRequest(Builder requestBuilder, AuthenticationToken token) {
        return requestBuilder.header(HttpHeaders.AUTHORIZATION, "Bearer " + 
        Base64.getEncoder().encodeToString(String.valueOf(token.getPrincipal() + ":" + token.getToken()).getBytes()));
    }
    
    private WebTarget appendParams(WebTarget target, Map<String, Object> params) {
        for (Entry<String, Object> param : params.entrySet()) {
            target = target.queryParam(param.getKey(), param.getValue().toString());
        }
        return target;
    }
    
    private Response post(String path, Object request) {
        try {
            return webTarget.path(path).request(MediaType.APPLICATION_JSON).post(Entity.entity(request, MediaType.APPLICATION_JSON));
        } catch (ProcessingException ex) {
            throw new TasteItClientException("Failed to process request", ex);
        }
    }
    
    private Response postWithAuthentication(String path, Object request, AuthenticationToken token) {
        try {
            return authenticateRequest(webTarget.path(path).request(MediaType.APPLICATION_JSON), token)
                    .post(Entity.entity(request, MediaType.APPLICATION_JSON));
        } catch (ProcessingException ex) {
            throw new TasteItClientException("Failed to process request", ex);
        }
    }

    private Response getWithAuthentication(String path, Map<String, Object> params, AuthenticationToken token) {
        try {
            return authenticateRequest(appendParams(webTarget.path(path), params).request(MediaType.APPLICATION_JSON), token).get();
        } catch (ProcessingException ex) {
            throw new TasteItClientException("Failed to process request", ex);
        }
    }
    
    private Response delete(String path, Map<String, Object> params) {
        try {
            return appendParams(webTarget.path(path), params).request(MediaType.APPLICATION_JSON).delete();
        } catch (ProcessingException ex) {
            throw new TasteItClientException("Failed to process request", ex);
        }
    }
    
    private Response deleteWithAuthentication(String path, Map<String, Object> params, AuthenticationToken token) {
        try {
            return authenticateRequest(appendParams(webTarget.path(path), params).request(MediaType.APPLICATION_JSON), token).delete();
        } catch (ProcessingException ex) {
            throw new TasteItClientException("Failed to process request", ex);
        }
    }
    
    @Override
    public GenerateTokenResponse generateAccessToken(GenerateTokenRequest request)
            throws TasteItClientException, TasteItServiceException {
        if (request == null) {
            throw new TasteItClientException("one of the paramter is null", null);
        }
        Response response = post("v1/tokens", request);
        GenerateTokenResponse token = ResponseHandler.readEntity(response, GenerateTokenResponse.class);
        return token;
    }

    @Override
    public void revokeAccessToken(RevokeTokenRequest request)
            throws TasteItClientException, TasteItServiceException {
        if (request == null) {
            throw new TasteItClientException("one of the paramter is null", null);
        }
        Response response = delete("/v1/tokens",
                ImmutableMap.of(RevokeTokenRequest.TOKEN_TYPE, request.getTokenType(), 
                        RevokeTokenRequest.TOKEN, request.getToken(),
                        RevokeTokenRequest.PRINCIPAL, request.getPrincipal()));
        
        ResponseHandler.checkException(response);
    }
    
    @Override
    public GetRestaurantResponse getRestaurant(GetRestaurantRequest request, AuthenticationToken token) 
            throws TasteItClientException, TasteItServiceException {
        if (request == null || token == null) {
            throw new TasteItClientException("one of the paramter is null", null);
        }
        Response response = getWithAuthentication("/v1/customers/restaurant", 
                ImmutableMap.of(GetRestaurantRequest.GEO_RESTAURANT_ID, request.getRestaurantId()), token);

        GetRestaurantResponse restaurant = ResponseHandler.readEntity(response, GetRestaurantResponse.class);
        return restaurant;
    }

    @Override
    public GetRestaurantMenuResponse getRestaurantMenu(GetRestaurantRequest request, AuthenticationToken token) 
            throws TasteItClientException, TasteItServiceException {
        if (request == null || token == null) {
            throw new TasteItClientException("one of the paramter is null", null);
        }
        Response response = getWithAuthentication("/v1/customers/restaurant/menu", 
                ImmutableMap.of(GetRestaurantRequest.GEO_RESTAURANT_ID, request.getRestaurantId()), token);

        GetRestaurantMenuResponse restaurantMenu = ResponseHandler.readEntity(response, GetRestaurantMenuResponse.class);
        return restaurantMenu;
    }
    
    @Override
    public Cuisine getCuisine(GetCuisineRequest request, AuthenticationToken token) 
            throws TasteItClientException, TasteItServiceException {
        if (request == null || token == null) {
            throw new TasteItClientException("one of the paramter is null", null);
        }
        Response response = getWithAuthentication("/v1/customers/cuisine", 
                ImmutableMap.of(GetCuisineRequest.GEO_RESTAURANT_CUISINE_ID, request.getCuisineId()), token);

        Cuisine cuisine = ResponseHandler.readEntity(response, Cuisine.class);
        return cuisine;
    }

    @Override
    public void updateRestaurantInfo(UpdateRestaurantInfoRequest request, AuthenticationToken token) 
            throws TasteItClientException, TasteItServiceException {
        if (request == null || token == null) {
            throw new TasteItClientException("one of the paramter is null", null);
        }
        Response response = postWithAuthentication("/v1/customers/restaurant/info", request, token);
        
        ResponseHandler.checkException(response);
    }

    @Override
    public void updateRestaurantDetail(UpdateRestaurantDetailRequest request, AuthenticationToken token) 
            throws TasteItClientException, TasteItServiceException {
        if (request == null || token == null) {
            throw new TasteItClientException("one of the paramter is null", null);
        }
        Response response = postWithAuthentication("/v1/customers/restaurant/detail", request, token);

        ResponseHandler.checkException(response);
    }

    @Override
    public void updateRestaurantOpenHours(UpdateRestaurantOpenHoursRequest request, AuthenticationToken token) 
            throws TasteItClientException, TasteItServiceException {
        if (request == null || token == null) {
            throw new TasteItClientException("one of the paramter is null", null);
        }
        Response response = postWithAuthentication("/v1/customers/restaurant/openhour", request, token);
        
        ResponseHandler.checkException(response);
    }

    @Override
    public void updateCuisine(UpdateCuisineRequest request, AuthenticationToken token) 
            throws TasteItClientException, TasteItServiceException {
        if (request == null || token == null) {
            throw new TasteItClientException("one of the paramter is null", null);
        }
        Response response = postWithAuthentication("/v1/customers/cuisine", request, token);
        
        ResponseHandler.checkException(response);
    }

    @Override
    public void resetCustomerCredential(ResetCustomerRequest request) throws TasteItClientException, TasteItServiceException {
        if (request == null) {
            throw new TasteItClientException("one of the paramter is null", null);
        }
        Response response = post("/v1/customers/profile/reset", request);
        
        ResponseHandler.checkException(response);
    }

    @Override
    public void addPromotionImage(UploadPromotionImageRequest request, AuthenticationToken token) 
            throws TasteItClientException, TasteItServiceException {
        if (request == null || token == null) {
            throw new TasteItClientException("one of the paramter is null", null);
        }
        Response response = postWithAuthentication("/v1/customers/restaurant/images/new", request, token);
        
        ResponseHandler.checkException(response);
    }

    @Override
    public void deletePromotionImage(DeletePromotionImageRequest request, AuthenticationToken token) 
            throws TasteItClientException, TasteItServiceException {
        if (request == null || token == null) {
            throw new TasteItClientException("one of the paramter is null", null);
        }
        Response response = deleteWithAuthentication("/v1/customers/restaurant/images", 
                ImmutableMap.of(DeletePromotionImageRequest.RESTAURANT_ID, request.getRestaurantId(),
                        DeletePromotionImageRequest.IMAGE_ID, request.getPromotionImageId()), token);
        
        ResponseHandler.checkException(response);
    }

    @Override
    public void updatePromotionImageDisplayOrder(UpdatePromotionImageDisplayOrderRequest request, AuthenticationToken token) 
            throws TasteItClientException, TasteItServiceException {
        if (request == null || token == null) {
            throw new TasteItClientException("one of the paramter is null", null);
        }
        Response response = postWithAuthentication("/v1/customers/restaurant/images", request, token);
        
        ResponseHandler.checkException(response);
    }
    
    @Override
    public void shutdown() {
        client.close();
    }
}
