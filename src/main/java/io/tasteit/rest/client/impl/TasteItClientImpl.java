package io.tasteit.rest.client.impl;

import io.tasteit.rest.activities.exception.BadRequestException;
import io.tasteit.rest.activities.exception.InternalServerErrorException;
import io.tasteit.rest.activities.model.RestaurantDetail;
import io.tasteit.rest.activities.model.request.RestaurantRequest;
import io.tasteit.rest.client.TasteItClient;
import io.tasteit.rest.utils.PropertiesParser;

import java.io.IOException;
import java.net.URI;

import javax.annotation.Nonnull;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.grizzly.connector.GrizzlyConnectorProvider;

public class TasteItClientImpl implements TasteItClient {
    private static final Logger LOG = LogManager.getLogger(TasteItClientImpl.class);

    private static final String SERVER_PROPERTIES_FILE = "server.properties";
    private static final String BASE_URL = "BASE_URL";
    private static final String PORT = "PORT";

    private final Client client;
    private final WebTarget webTarget;

    private static TasteItClientImpl instance;
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                if (instance != null) {
                    try {
                        instance.close();
                        instance = null;
                    } catch (Exception error) {
                        LOG.error("Failed to close TasteItClient", error);
                    }
                }
            }
        }, "TasteItClient-ShutdownHook"));
    }

    public static synchronized TasteItClientImpl get() {
        if (instance != null) {
            return instance;
        }

        try {
            PropertiesParser serverPropertiesParser = new PropertiesParser(SERVER_PROPERTIES_FILE);
            String baseUrl = serverPropertiesParser.getProperty(BASE_URL);
            String port = serverPropertiesParser.getProperty(PORT);

            ClientConfig clientConfig = new ClientConfig().connectorProvider(new GrizzlyConnectorProvider());
            clientConfig.register(JSONObjectMapperImpl.class);
            Client client = ClientBuilder.newBuilder().withConfig(clientConfig).build();
            return instance = new TasteItClientImpl(client, UriBuilder.fromUri(baseUrl).port(Integer.parseInt(port)).build());
        } catch (Exception error) {
            throw new RuntimeException("Failed while attempting to initialize TasteItClient", error);
        }
    }

    private TasteItClientImpl(@Nonnull Client client, @Nonnull URI uri) {
        this.client = client;
        this.webTarget = client.target(uri);
    }

    public void close() throws IOException {
        client.close();
    }

    @Override
    public RestaurantDetail getRestaurantDetail(RestaurantRequest request) 
            throws BadRequestException, InternalServerErrorException {
        Response response = webTarget.path("v1/restaurants/detail").queryParam(RestaurantRequest.GEO_RESTAURANT_ID, request.getRestaurantId())
                .request(MediaType.APPLICATION_JSON).get();

        ResponseHandler<RestaurantDetail> responseHandler = new ResponseHandler<>(RestaurantDetail.class);

        RestaurantDetail restaurantDetail = responseHandler.readEntity(response);
        System.out.println(restaurantDetail);
        
        return restaurantDetail;
    }
}
