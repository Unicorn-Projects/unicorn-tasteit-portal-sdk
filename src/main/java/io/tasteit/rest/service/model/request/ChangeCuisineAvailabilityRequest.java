package io.tasteit.rest.service.model.request;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.StringUtils;

public class ChangeCuisineAvailabilityRequest {
    
    @Nonnull private String cuisineId;

    public ChangeCuisineAvailabilityRequest(String cuisineId) {
        if (StringUtils.isBlank(cuisineId)) {
            throw new IllegalArgumentException("cuisineId should not be null or empty");
        }
        this.cuisineId = cuisineId;
    }

    public String getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(String cuisineId) {
        this.cuisineId = cuisineId;
    }
}
