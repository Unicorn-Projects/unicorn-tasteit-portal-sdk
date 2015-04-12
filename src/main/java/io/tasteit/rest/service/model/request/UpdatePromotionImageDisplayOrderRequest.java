package io.tasteit.rest.service.model.request;

import java.util.List;

import javax.annotation.Nonnull;

public class UpdatePromotionImageDisplayOrderRequest {
    @Nonnull
    private String restaurantId;
    @Nonnull
    private List<String> imageDisplayOrder;

    public UpdatePromotionImageDisplayOrderRequest(String restaurantId, List<String> imageDisplayOrder) {
        super();
        
        if (restaurantId == null || imageDisplayOrder == null) {
            throw new IllegalArgumentException("one of the paramter is null");
        }
        
        this.restaurantId = restaurantId;
        this.imageDisplayOrder = imageDisplayOrder;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<String> getImageDisplayOrder() {
        return imageDisplayOrder;
    }

    public void setImageDisplayOrder(List<String> imageDisplayOrder) {
        this.imageDisplayOrder = imageDisplayOrder;
    }

}
