package io.tasteit.rest.service.model.response;

import io.tasteit.rest.service.model.Cuisine;

import java.util.List;

public class GetRestaurantMenuResponse {

    private List<Cuisine> restaurantCuisines;

    public GetRestaurantMenuResponse() {}

    public List<Cuisine> getRestaurantCuisines() {
        return restaurantCuisines;
    }

    @Override
    public String toString() {
        return "GetRestaurantMenuResponse [restaurantCuisines=" + restaurantCuisines + "]";
    }
}
