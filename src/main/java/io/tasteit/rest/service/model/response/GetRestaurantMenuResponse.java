package io.tasteit.rest.service.model.response;

import io.tasteit.rest.service.model.Cuisine;

import java.util.List;

public class GetRestaurantMenuResponse {
    
    private List<Cuisine> cuisines;
    
    public GetRestaurantMenuResponse() {}

    public List<Cuisine> getCuisines() {
        return cuisines;
    }

    @Override
    public String toString() {
        return "GetRestaurantMenuResponse [cuisines=" + cuisines + "]";
    }
}
