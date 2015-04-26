package io.tasteit.rest.service.model.request;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.StringUtils;

public class GetCuisineRequest {

    public static final String GEO_RESTAURANT_CUISINE_ID = "cuisine_id";  
    @Nonnull private String cuisineId;

    public GetCuisineRequest(String cuisineId) {
        if (StringUtils.isBlank(cuisineId)) {
            throw new IllegalArgumentException("cuisineId should not be null or empty");
        }
        this.cuisineId = cuisineId;
    }

    public @Nonnull String getCuisineId() {
        return cuisineId;
    }

    @Override
    public @Nonnull String toString() {
        return "GetCuisineRequest [cuisineId=" + cuisineId + "]";
    }
}
