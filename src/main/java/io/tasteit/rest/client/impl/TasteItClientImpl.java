package io.tasteit.rest.client.impl;

import io.tasteit.rest.client.TasteItClient;
import io.tasteit.rest.service.model.exception.TasteItClientException;
import io.tasteit.rest.service.model.exception.TasteItServiceException;
import io.tasteit.rest.service.model.request.GenerateTokenRequest;
import io.tasteit.rest.service.model.request.GetRestaurantRequest;
import io.tasteit.rest.service.model.request.RevokeTokenRequest;
import io.tasteit.rest.service.model.response.GenerateTokenResponse;
import io.tasteit.rest.service.model.response.GetRestaurantMenuResponse;
import io.tasteit.rest.service.model.response.GetRestaurantResponse;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.grizzly.connector.GrizzlyConnectorProvider;

public class TasteItClientImpl implements TasteItClient {

    private final Client client;
    private final WebTarget webTarget;

    public TasteItClientImpl(String baseUrl, Integer port) {
        try {
            if (StringUtils.isBlank(baseUrl) || port == null) {
                throw new IllegalArgumentException("baseUrl and port should not be null or empty");
            }
            ClientConfig clientConfig = new ClientConfig().connectorProvider(new GrizzlyConnectorProvider());
            clientConfig.register(JSONObjectMapperImpl.class);
            this.client = ClientBuilder.newBuilder().withConfig(clientConfig).build();
            this.webTarget = client.target(UriBuilder.fromUri(baseUrl).port(port).build());
        } catch (Exception error) {
            throw new RuntimeException("Failed while attempting to initialize TasteItClient", error);
        }
    }

    public void shutdown() throws IOException {
        client.close();
    }
    
    @Override
    public GenerateTokenResponse generateAccessToken(GenerateTokenRequest request)
            throws TasteItClientException, TasteItServiceException {
        Response response = webTarget.path("/v1/token").request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(request, MediaType.APPLICATION_JSON));
        
        GenerateTokenResponse token = ResponseHandler.readEntity(response, GenerateTokenResponse.class);
        return token;
    }

    @Override
    public void revokeAccessToken(RevokeTokenRequest request)
            throws TasteItClientException, TasteItServiceException {
        Response response = webTarget.queryParam(RevokeTokenRequest.TOKEN_TYPE, request.getTokenType())
                .queryParam(RevokeTokenRequest.TOKEN, request.getToken()).queryParam(RevokeTokenRequest.PRINCIPAL, request.getPrincipal()).request(MediaType.APPLICATION_JSON).delete();
        
        ResponseHandler.checkException(response);
    }

    @Override
    public GetRestaurantResponse getRestaurant(GetRestaurantRequest request) 
            throws TasteItClientException, TasteItServiceException {
        Response response = webTarget.path("/v1/customers/restaurant").queryParam(GetRestaurantRequest.GEO_RESTAURANT_ID, request.getRestaurantId())
                .request(MediaType.APPLICATION_JSON).get();

        GetRestaurantResponse restaurant = ResponseHandler.readEntity(response, GetRestaurantResponse.class);
        return restaurant;
    }

    @Override
    public GetRestaurantMenuResponse getRestaurantMenu(GetRestaurantRequest request) 
            throws TasteItClientException, TasteItServiceException {
        Response response = webTarget.path("/v1/customers/restaurant/menu").queryParam(GetRestaurantRequest.GEO_RESTAURANT_ID, request.getRestaurantId())
                .request(MediaType.APPLICATION_JSON).get();

        GetRestaurantMenuResponse restaurantMenu = ResponseHandler.readEntity(response, GetRestaurantMenuResponse.class);
        return restaurantMenu;
    }
}
