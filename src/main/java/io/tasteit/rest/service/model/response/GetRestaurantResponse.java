package io.tasteit.rest.service.model.response;

import io.tasteit.rest.service.model.Address;
import io.tasteit.rest.service.model.Restaurant;
import io.tasteit.rest.service.model.RestaurantDetail;
import io.tasteit.rest.service.model.RestaurantInfo;
import io.tasteit.rest.service.model.RestaurantPromotionImages;
import io.tasteit.rest.service.model.WeekdaysOpenHour;
import io.tasteit.rest.service.model.WeekdaysOpenHours;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GetRestaurantResponse {

    private String restaurantId;
    private String restaurantName;
    private Integer logoVersion;
    private String logoUrl;
    private Double latitude;
    private Double longitude;

    private Long favorites;
    private Long followers;

    private List<Integer> displayImages;
    private List<String> displayImagesUrls;
    private List<Integer> imagesRepo;
    private List<String> imagesRepoUrls;

    private Address address;
    private String contact;
    private String website;

    private Map<String, List<WeekdaysOpenHour>> openHours;

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Integer getLogoVersion() {
        return logoVersion;
    }

    public void setLogoVersion(Integer logoVersion) {
        this.logoVersion = logoVersion;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getFavorites() {
        return favorites;
    }

    public void setFavorites(Long favorites) {
        this.favorites = favorites;
    }

    public Long getFollowers() {
        return followers;
    }

    public void setFollowers(Long followers) {
        this.followers = followers;
    }

    public List<Integer> getDisplayImages() {
        return displayImages;
    }

    public void setDisplayImages(List<Integer> displayImages) {
        this.displayImages = displayImages;
    }

    public List<String> getDisplayImagesUrls() {
        return displayImagesUrls;
    }

    public void setDisplayImagesUrls(List<String> displayImagesUrls) {
        this.displayImagesUrls = displayImagesUrls;
    }

    public List<Integer> getImagesRepo() {
        return imagesRepo;
    }

    public void setImagesRepo(List<Integer> imagesRepo) {
        this.imagesRepo = imagesRepo;
    }

    public List<String> getImagesRepoUrls() {
        return imagesRepoUrls;
    }

    public void setImagesRepoUrls(List<String> imagesRepoUrls) {
        this.imagesRepoUrls = imagesRepoUrls;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public Map<String, List<WeekdaysOpenHour>> getOpenHours() {
        return openHours;
    }

    public void setOpenHours(Map<String, List<WeekdaysOpenHour>> openHours) {
        this.openHours = openHours;
    }

    public Restaurant buildRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(restaurantId);

        RestaurantInfo restaurantInfo = new RestaurantInfo();
        restaurantInfo.setRestaurantName(restaurantName);
        restaurantInfo.setLatitude(latitude);
        restaurantInfo.setLongitude(longitude);
        restaurantInfo.setAddress(address);
        restaurantInfo.setLogoVersion(logoVersion);
        restaurantInfo.setLogoUrl(logoUrl);
        restaurantInfo.setFavorites(favorites);
        restaurantInfo.setFollowers(followers);
        restaurant.setRestaurantInfo(restaurantInfo);

        RestaurantDetail restaurantDetail = new RestaurantDetail();
        restaurantDetail.setContact(contact);
        restaurantDetail.setWebsite(website);
        restaurant.setRestaurantDetail(restaurantDetail);

        RestaurantPromotionImages restaurantPromotionImages = new RestaurantPromotionImages();
        restaurantPromotionImages.setDisplayImages(displayImages);
        restaurantPromotionImages.setDisplayImagesUrls(displayImagesUrls);
        restaurantPromotionImages.setImagesRepo(imagesRepo);
        restaurantPromotionImages.setImagesRepoUrls(imagesRepoUrls);
        restaurant.setRestaurantPromotionImages(restaurantPromotionImages);

        Map<String, WeekdaysOpenHours> restaurantOpenHours = new HashMap<>();
        for (Entry<String, List<WeekdaysOpenHour>> openHour : openHours.entrySet()) {
            WeekdaysOpenHours weekdaysOpenHours = new WeekdaysOpenHours();
            weekdaysOpenHours.setWeekdaysOpenHours(openHour.getValue());
            restaurantOpenHours.put(openHour.getKey(), weekdaysOpenHours);
        }
        restaurant.setRestaurantOpenHours(restaurantOpenHours);

        return restaurant;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((contact == null) ? 0 : contact.hashCode());
        result = prime * result
                + ((displayImages == null) ? 0 : displayImages.hashCode());
        result = prime
                * result
                + ((displayImagesUrls == null) ? 0 : displayImagesUrls
                        .hashCode());
        result = prime * result
                + ((favorites == null) ? 0 : favorites.hashCode());
        result = prime * result
                + ((followers == null) ? 0 : followers.hashCode());
        result = prime * result
                + ((imagesRepo == null) ? 0 : imagesRepo.hashCode());
        result = prime * result
                + ((imagesRepoUrls == null) ? 0 : imagesRepoUrls.hashCode());
        result = prime * result
                + ((latitude == null) ? 0 : latitude.hashCode());
        result = prime * result + ((logoUrl == null) ? 0 : logoUrl.hashCode());
        result = prime * result
                + ((logoVersion == null) ? 0 : logoVersion.hashCode());
        result = prime * result
                + ((longitude == null) ? 0 : longitude.hashCode());
        result = prime * result
                + ((openHours == null) ? 0 : openHours.hashCode());
        result = prime * result
                + ((restaurantId == null) ? 0 : restaurantId.hashCode());
        result = prime * result
                + ((restaurantName == null) ? 0 : restaurantName.hashCode());
        result = prime * result + ((website == null) ? 0 : website.hashCode());
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
        GetRestaurantResponse other = (GetRestaurantResponse) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (contact == null) {
            if (other.contact != null)
                return false;
        } else if (!contact.equals(other.contact))
            return false;
        if (displayImages == null) {
            if (other.displayImages != null)
                return false;
        } else if (!displayImages.equals(other.displayImages))
            return false;
        if (displayImagesUrls == null) {
            if (other.displayImagesUrls != null)
                return false;
        } else if (!displayImagesUrls.equals(other.displayImagesUrls))
            return false;
        if (favorites == null) {
            if (other.favorites != null)
                return false;
        } else if (!favorites.equals(other.favorites))
            return false;
        if (followers == null) {
            if (other.followers != null)
                return false;
        } else if (!followers.equals(other.followers))
            return false;
        if (imagesRepo == null) {
            if (other.imagesRepo != null)
                return false;
        } else if (!imagesRepo.equals(other.imagesRepo))
            return false;
        if (imagesRepoUrls == null) {
            if (other.imagesRepoUrls != null)
                return false;
        } else if (!imagesRepoUrls.equals(other.imagesRepoUrls))
            return false;
        if (latitude == null) {
            if (other.latitude != null)
                return false;
        } else if (!latitude.equals(other.latitude))
            return false;
        if (logoUrl == null) {
            if (other.logoUrl != null)
                return false;
        } else if (!logoUrl.equals(other.logoUrl))
            return false;
        if (logoVersion == null) {
            if (other.logoVersion != null)
                return false;
        } else if (!logoVersion.equals(other.logoVersion))
            return false;
        if (longitude == null) {
            if (other.longitude != null)
                return false;
        } else if (!longitude.equals(other.longitude))
            return false;
        if (openHours == null) {
            if (other.openHours != null)
                return false;
        } else if (!openHours.equals(other.openHours))
            return false;
        if (restaurantId == null) {
            if (other.restaurantId != null)
                return false;
        } else if (!restaurantId.equals(other.restaurantId))
            return false;
        if (restaurantName == null) {
            if (other.restaurantName != null)
                return false;
        } else if (!restaurantName.equals(other.restaurantName))
            return false;
        if (website == null) {
            if (other.website != null)
                return false;
        } else if (!website.equals(other.website))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "GetRestaurantResponse [restaurantId=" + restaurantId
                + ", restaurantName=" + restaurantName + ", logoVersion="
                + logoVersion + ", logoUrl=" + logoUrl + ", latitude="
                + latitude + ", longitude=" + longitude + ", favorites="
                + favorites + ", followers=" + followers
                + ", displayImages=" + displayImages + ", displayImagesUrls="
                + displayImagesUrls + ", imagesRepo=" + imagesRepo
                + ", imagesRepoUrls=" + imagesRepoUrls + ", address=" + address
                + ", contact=" + contact + ", website=" + website
                + ", openHours=" + openHours + "]";
    }
}
