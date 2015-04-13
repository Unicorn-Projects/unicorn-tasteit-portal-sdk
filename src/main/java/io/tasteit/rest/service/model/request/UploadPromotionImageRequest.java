package io.tasteit.rest.service.model.request;

import io.tasteit.rest.service.model.exception.TasteItClientException;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.annotation.Nonnull;
import javax.imageio.ImageIO;

public class UploadPromotionImageRequest {
    @Nonnull private String restaurantId;
    @Nonnull private String imageData;
    
    public static final String JPG = "jpg";
    
    public UploadPromotionImageRequest(String restaurantId, BufferedImage image) {
        super();
        
        if (restaurantId == null || image == null) {
            throw new IllegalArgumentException("one of the paramter is null");
        }
        
        try {
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        ImageIO.write(image, JPG, outputStream);
	        byte[] bytes = outputStream.toByteArray();
	        outputStream.close();
	        this.restaurantId = restaurantId;
	        this.imageData = Base64.getEncoder().encodeToString(bytes);
        } catch (IOException ex) {
        	throw new TasteItClientException("failed to convert buffered image to base64 encoded string data", ex);
        }
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
