package io.tasteit.rest.service.model.response;

import io.tasteit.rest.service.model.RestaurantDetail;
import io.tasteit.rest.service.model.RestaurantInfo;
import io.tasteit.rest.service.model.RestaurantOpenHours;

public class GetRestaurantResponse {

    private RestaurantInfo restaurantInfo;
    private RestaurantDetail restaurantDetail;
    private RestaurantOpenHours restaurantOpenHours;
    
    public GetRestaurantResponse() {}

    public RestaurantInfo getRestaurantInfo() {
        return restaurantInfo;
    }
    public RestaurantDetail getRestaurantDetail() {
        return restaurantDetail;
    }
    public RestaurantOpenHours getRestaurantOpenHours() {
        return restaurantOpenHours;
    }

    @Override
    public String toString() {
        return "Restaurant [restaurantInfo=" + restaurantInfo
                + ", restaurantDetail=" + restaurantDetail
                + ", restaurantOpenHours=" + restaurantOpenHours + "]";
    }
}
