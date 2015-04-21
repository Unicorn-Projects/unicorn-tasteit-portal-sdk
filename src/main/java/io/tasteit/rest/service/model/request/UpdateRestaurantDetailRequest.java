package io.tasteit.rest.service.model.request;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;

public class UpdateRestaurantDetailRequest {

    @Nonnull private String restaurantId;
    @Nullable private String contact;
    @Nullable private String website;
    @Nullable private String reservationLink;
    
    public UpdateRestaurantDetailRequest(@Nonnull String restaurantId) {
        if (StringUtils.isBlank(restaurantId)) {
            throw new IllegalArgumentException("restaurantId should not be null or empty");
        }
        this.restaurantId = restaurantId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getReservationLink() {
        return reservationLink;
    }

    public void setReservationLink(String reservationLink) {
        this.reservationLink = reservationLink;
    }
}
