package io.tasteit.rest.service.model;

public class Restaurant {
    
    private String restaurantId;
    private RestaurantInfo restaurantInfo;
    private RestaurantDetail restaurantDetail;
    private RestaurantPromotionImages restaurantPromotionImages;
    private RestaurantOpenHours restaurantOpenHours;
    
    public String getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }
    public RestaurantInfo getRestaurantInfo() {
        return restaurantInfo;
    }
    public void setRestaurantInfo(RestaurantInfo restaurantInfo) {
        this.restaurantInfo = restaurantInfo;
    }
    public RestaurantDetail getRestaurantDetail() {
        return restaurantDetail;
    }
    public void setRestaurantDetail(RestaurantDetail restaurantDetail) {
        this.restaurantDetail = restaurantDetail;
    }
    public RestaurantPromotionImages getRestaurantPromotionImages() {
        return restaurantPromotionImages;
    }
    public void setRestaurantPromotionImages(
            RestaurantPromotionImages restaurantPromotionImages) {
        this.restaurantPromotionImages = restaurantPromotionImages;
    }
    public RestaurantOpenHours getRestaurantOpenHours() {
        return restaurantOpenHours;
    }
    public void setRestaurantOpenHours(RestaurantOpenHours restaurantOpenHours) {
        this.restaurantOpenHours = restaurantOpenHours;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
                * result
                + ((restaurantDetail == null) ? 0 : restaurantDetail.hashCode());
        result = prime * result
                + ((restaurantId == null) ? 0 : restaurantId.hashCode());
        result = prime * result
                + ((restaurantInfo == null) ? 0 : restaurantInfo.hashCode());
        result = prime
                * result
                + ((restaurantOpenHours == null) ? 0 : restaurantOpenHours
                        .hashCode());
        result = prime
                * result
                + ((restaurantPromotionImages == null) ? 0
                        : restaurantPromotionImages.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Restaurant other = (Restaurant) obj;
        if (restaurantDetail == null) {
            if (other.restaurantDetail != null)
                return false;
        } else if (!restaurantDetail.equals(other.restaurantDetail))
            return false;
        if (restaurantId == null) {
            if (other.restaurantId != null)
                return false;
        } else if (!restaurantId.equals(other.restaurantId))
            return false;
        if (restaurantInfo == null) {
            if (other.restaurantInfo != null)
                return false;
        } else if (!restaurantInfo.equals(other.restaurantInfo))
            return false;
        if (restaurantOpenHours == null) {
            if (other.restaurantOpenHours != null)
                return false;
        } else if (!restaurantOpenHours.equals(other.restaurantOpenHours))
            return false;
        if (restaurantPromotionImages == null) {
            if (other.restaurantPromotionImages != null)
                return false;
        } else if (!restaurantPromotionImages
                .equals(other.restaurantPromotionImages))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "Restaurant [restaurantId=" + restaurantId + ", restaurantInfo="
                + restaurantInfo + ", restaurantDetail=" + restaurantDetail
                + ", restaurantPromotionImages=" + restaurantPromotionImages
                + ", restaurantOpenHours=" + restaurantOpenHours + "]";
    }
}
