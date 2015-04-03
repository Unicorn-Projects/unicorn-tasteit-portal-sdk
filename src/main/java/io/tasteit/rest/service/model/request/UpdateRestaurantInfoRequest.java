package io.tasteit.rest.service.model.request;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;

public class UpdateRestaurantInfoRequest {
    
    @Nonnull private String restaurantId;
    @Nullable private String restaurantName;
    @Nullable private List<String> cuisinesCategories;
    @Nullable private List<String> cuisinesTypes;
    @Nullable private List<String> mealsTypes;
    
    public UpdateRestaurantInfoRequest(@Nonnull String restaurantId) {
        if (StringUtils.isBlank(restaurantId)) {
            throw new IllegalArgumentException("restaurantId should not be null or empty");
        }
        this.restaurantId = restaurantId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public List<String> getCuisinesCategories() {
        return cuisinesCategories;
    }

    public void setCuisinesCategories(List<String> cuisinesCategories) {
        this.cuisinesCategories = cuisinesCategories;
    }

    public List<String> getCuisinesTypes() {
        return cuisinesTypes;
    }

    public void setCuisinesTypes(List<String> cuisinesTypes) {
        this.cuisinesTypes = cuisinesTypes;
    }

    public List<String> getMealsTypes() {
        return mealsTypes;
    }

    public void setMealsTypes(List<String> mealsTypes) {
        this.mealsTypes = mealsTypes;
    }
}
