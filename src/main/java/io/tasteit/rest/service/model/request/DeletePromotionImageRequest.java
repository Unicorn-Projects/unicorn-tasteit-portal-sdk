package io.tasteit.rest.service.model.request;

import javax.annotation.Nonnull;

public class DeletePromotionImageRequest {

    public static final String RESTAURANT_ID = "restaurant_id";
    public static final String IMAGE_ID = "promotion_image_id";
    
    @Nonnull private String restaurantId;
    @Nonnull private String promotionImageId;

    public DeletePromotionImageRequest(String restaurantId, String promotionImageId) {
        super();
        if (restaurantId == null || promotionImageId == null) {
            throw new IllegalArgumentException("one of the paramter is null");
        }
        
        this.restaurantId = restaurantId;
        this.promotionImageId = promotionImageId;
    }

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getPromotionImageId() {
		return promotionImageId;
	}

	public void setPromotionImageId(String promotionImageId) {
		this.promotionImageId = promotionImageId;
	}
    
    
}
