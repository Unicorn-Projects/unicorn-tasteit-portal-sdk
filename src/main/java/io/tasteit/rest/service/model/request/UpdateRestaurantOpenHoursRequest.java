package io.tasteit.rest.service.model.request;

import io.tasteit.rest.service.model.WeekdaysOpenHour;

import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;

public class UpdateRestaurantOpenHoursRequest {

    @Nonnull private String restaurantId;
    @Nullable private Map<String, List<WeekdaysOpenHour>> openHours;
    
    public UpdateRestaurantOpenHoursRequest(@Nonnull String restaurantId) {
        if (StringUtils.isBlank(restaurantId)) {
            throw new IllegalArgumentException("restaurantId should not be null or empty");
        }
        this.restaurantId = restaurantId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public Map<String, List<WeekdaysOpenHour>> getOpenHours() {
        return openHours;
    }

    public void setOpenHours(Map<String, List<WeekdaysOpenHour>> openHours) {
        this.openHours = openHours;
    }
    
}
