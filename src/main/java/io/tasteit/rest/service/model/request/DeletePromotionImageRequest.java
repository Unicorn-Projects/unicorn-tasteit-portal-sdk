package io.tasteit.rest.service.model.request;

import javax.annotation.Nonnull;

public class DeletePromotionImageRequest {

    public static final String RESTAURANT_ID = "restaurant_id";
    public static final String IMAGE_ID = "image_id";
    
    @Nonnull private String restaurantId;
    @Nonnull private String imageId;

    public DeletePromotionImageRequest(String restaurantId, String imageId) {
        super();
        if (restaurantId == null || imageId == null) {
            throw new IllegalArgumentException("one of the paramter is null");
        }
        
        this.restaurantId = restaurantId;
        this.imageId = imageId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

}
