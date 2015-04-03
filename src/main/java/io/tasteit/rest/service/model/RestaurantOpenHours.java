package io.tasteit.rest.service.model;

import java.util.List;
import java.util.Map;

public class RestaurantOpenHours {

    private Map<String, List<WeekdaysOpenHour>> openHours;

    public RestaurantOpenHours() {}

    public Map<String, List<WeekdaysOpenHour>> getOpenHours() {
        return openHours;
    }
    public void setOpenHours(Map<String, List<WeekdaysOpenHour>> openHours) {
        this.openHours = openHours;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((openHours == null) ? 0 : openHours.hashCode());
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
        RestaurantOpenHours other = (RestaurantOpenHours) obj;
        if (openHours == null) {
            if (other.openHours != null)
                return false;
        } else if (!openHours.equals(other.openHours))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RestaurantOpenHours [openHours=" + openHours + "]";
    }
}
