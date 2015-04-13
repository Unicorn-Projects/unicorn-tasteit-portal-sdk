package io.tasteit.rest.service.model.request;

import java.util.List;

import javax.annotation.Nonnull;

public class UpdatePromotionImageDisplayOrderRequest {
    @Nonnull
    private String restaurantId;
    @Nonnull
    private List<String> imageIds;

    public UpdatePromotionImageDisplayOrderRequest(String restaurantId, List<String> imageIds) {
        super();
        
        if (restaurantId == null || imageIds == null) {
            throw new IllegalArgumentException("one of the paramter is null");
        }
        
        this.restaurantId = restaurantId;
        this.imageIds = imageIds;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<String> getimageIds() {
        return imageIds;
    }

    public void setimageIds(List<String> imageIds) {
        this.imageIds = imageIds;
    }

}
