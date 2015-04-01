package io.tasteit.rest.service.model.response;

import io.tasteit.rest.service.model.Address;

import java.util.List;

public class GetRestaurantResponse {

    private String restaurantId;
    private String restaurantName;
    private Integer logoVersion;
    private String logoUrl;
    private List<String> cuisinesCategories;
    private List<String> cuisinesTypes;
    private List<String> mealsTypes; 
    private Double latitude;
    private Double longitude;
    
    private Long favoriteCounter;
    private Long followedCounter;
    
    private Long ownerPrincipal;
    private List<String> imagesUrls;
    private Address address;
    private String contact;
    private String website;
    
//    private Map<String, Map<List<Integer>, OpenHour>> openHours;
    
    public GetRestaurantResponse() {}
    
    public String getRestaurantId() {
        return restaurantId;
    }
    public String getRestaurantName() {
        return restaurantName;
    }
    public Integer getLogoVersion() {
        return logoVersion;
    }
    public String getLogoUrl() {
        return logoUrl;
    }
    public List<String> getCuisinesCategories() {
        return cuisinesCategories;
    }
    public List<String> getCuisinesTypes() {
        return cuisinesTypes;
    }
    public List<String> getMealsTypes() {
        return mealsTypes;
    }
    public Double getLatitude() {
        return latitude;
    }
    public Double getLongitude() {
        return longitude;
    }
    public Long getFavoriteCounter() {
        return favoriteCounter;
    }
    public Long getFollowedCounter() {
        return followedCounter;
    }
    public Long getOwnerPrincipal() {
        return ownerPrincipal;
    }
    public List<String> getImagesUrls() {
        return imagesUrls;
    }
    public Address getAddress() {
        return address;
    }
    public String getContact() {
        return contact;
    }
    public String getWebsite() {
        return website;
    }
//    public Map<String, Map<List<Integer>, OpenHour>> getOpenHours() {
//        return openHours;
//    }

    @Override
    public String toString() {
        return "GetRestaurantResponse [restaurantId=" + restaurantId
                + ", restaurantName=" + restaurantName + ", logoVersion="
                + logoVersion + ", logoUrl=" + logoUrl
                + ", cuisinesCategories=" + cuisinesCategories
                + ", cuisinesTypes=" + cuisinesTypes + ", mealsTypes="
                + mealsTypes + ", latitude=" + latitude + ", longitude="
                + longitude + ", favoriteCounter=" + favoriteCounter
                + ", followedCounter=" + followedCounter + ", ownerPrincipal="
                + ownerPrincipal + ", imagesUrls=" + imagesUrls + ", address="
                + address + ", contact=" + contact + ", website=" + website
//                + ", openHours=" + openHours
                + "]";
    }
    
}
