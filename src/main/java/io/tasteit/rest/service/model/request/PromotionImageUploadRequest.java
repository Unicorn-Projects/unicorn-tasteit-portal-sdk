package io.tasteit.rest.service.model.request;

import javax.annotation.Nonnull;

public class PromotionImageUploadRequest {
    @Nonnull private String restaurantId;
    @Nonnull private String imageData;
    
    public PromotionImageUploadRequest(String restaurantId, String imageData) {
        super();
        
        if (restaurantId == null || imageData == null) {
            throw new IllegalArgumentException("one of the paramter is null");
        }
        
        this.restaurantId = restaurantId;
        this.imageData = imageData;
    }
    public String getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }
    public String getImage_data() {
        return imageData;
    }
    public void setImage_data(String imageData) {
        this.imageData = imageData;
    }
    
    
}
