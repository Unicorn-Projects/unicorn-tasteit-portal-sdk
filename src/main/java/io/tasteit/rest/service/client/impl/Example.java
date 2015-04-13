package io.tasteit.rest.service.client.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import javax.imageio.ImageIO;

import io.tasteit.rest.service.model.AuthenticationToken;
import io.tasteit.rest.service.model.exception.TasteItClientException;
import io.tasteit.rest.service.model.exception.TasteItServiceException;
import io.tasteit.rest.service.model.request.DeletePromotionImageRequest;
import io.tasteit.rest.service.model.request.GenerateTokenRequest;
import io.tasteit.rest.service.model.request.GetRestaurantRequest;
import io.tasteit.rest.service.model.request.RevokeTokenRequest;
import io.tasteit.rest.service.model.request.UpdatePromotionImageDisplayOrderRequest;
import io.tasteit.rest.service.model.request.UploadPromotionImageRequest;
import io.tasteit.rest.service.model.response.GenerateTokenResponse;
import io.tasteit.rest.service.model.response.GetRestaurantMenuResponse;
import io.tasteit.rest.service.model.response.GetRestaurantResponse;

public class Example {
    
    public static void main(String[] args) {
        TasteItServiceClientImpl client = new TasteItServiceClientImpl("https://api-gamma.tasteit.io", 443);
       
        GenerateTokenResponse tokenResponse = client.generateAccessToken(new GenerateTokenRequest("test@tasteit.io", "password123456"));
        AuthenticationToken token = tokenResponse.buildAuthorizationToken();
        System.out.println(token);
        
        try {
            GetRestaurantResponse restaurant = client.getRestaurant(new GetRestaurantRequest("c23n-83440033214612255"), token);
            System.out.println(restaurant);
            
            GetRestaurantMenuResponse restaurantMenu = client.getRestaurantMenu(new GetRestaurantRequest("c23n-83440033214612255"), token);
            System.out.println(restaurantMenu);
            
            client.addPromotionImage(new UploadPromotionImageRequest(restaurant.getRestaurantId(), 
            		getTestImage("src/test/resources/img/Test_image_input_1.jpg")), token);
            
            client.addPromotionImage(new UploadPromotionImageRequest(restaurant.getRestaurantId(), 
            		getTestImage("src/test/resources/img/Test_image_input_2.jpg")), token);
            
            client.updatePromotionImageDisplayOrder(
            		new UpdatePromotionImageDisplayOrderRequest(restaurant.getRestaurantId(), Arrays.asList("2", "1")), token);
            
            restaurant = client.getRestaurant(new GetRestaurantRequest("c23n-83440033214612255"), token);
            System.out.println(restaurant);
            
            client.deletePromotionImage(new DeletePromotionImageRequest(restaurant.getRestaurantId(), "2"), token);
            client.deletePromotionImage(new DeletePromotionImageRequest(restaurant.getRestaurantId(), "1"), token);

            restaurant = client.getRestaurant(new GetRestaurantRequest("c23n-83440033214612255"), token);
            System.out.println(restaurant);
            
        } catch (TasteItClientException error) {
            System.out.println(error);
        } catch (TasteItServiceException error) {
        	error.printStackTrace(System.out);
            System.out.println(error);
        } finally {
            client.revokeAccessToken(new RevokeTokenRequest(token.getTokenType(), token.getToken(), token.getPrincipal()));
        }
        System.exit(0);
    }
    
    public static BufferedImage getTestImage(String imageFileName) {
    	try {
            File imageFile = new File(imageFileName);
	        InputStream inputStream = new FileInputStream(imageFile);
	        BufferedImage image = ImageIO.read(inputStream);
	        inputStream.close();
	        return image;
    	} catch (IOException ex) {
    		throw new TasteItClientException("failed to find test image", ex);
    	}
    }
}
