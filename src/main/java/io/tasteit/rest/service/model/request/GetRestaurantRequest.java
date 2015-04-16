package io.tasteit.rest.service.model.request;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.StringUtils;

public class GetRestaurantRequest {

    public static final String GEO_RESTAURANT_ID = "restaurant_id";  
    @Nonnull private String restaurantId;

    public GetRestaurantRequest(String restaurantId) {
        if (StringUtils.isBlank(restaurantId)) {
            throw new IllegalArgumentException("restaurantId should not be null or empty");
        }
        this.restaurantId = restaurantId;
    }

    public @Nonnull String getRestaurantId() {
        return restaurantId;
    }

    @Override
    public @Nonnull String toString() {
        return "GetRestaurantRequest [restaurantId=" + restaurantId + "]";
    }
}
