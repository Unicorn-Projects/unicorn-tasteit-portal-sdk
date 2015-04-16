package io.tasteit.rest.service.model;

public class RestaurantInfo {

    private String restaurantName;
    private Address address;
    private Double latitude;
    private Double longitude;
    private Integer logoVersion;
    private String logoUrl;
    
    private Long favorites;
    private Long followers;
    
    public String getRestaurantName() {
        return restaurantName;
    }
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
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
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result
                + ((favorites == null) ? 0 : favorites.hashCode());
        result = prime * result
                + ((followers == null) ? 0 : followers.hashCode());
        result = prime * result
                + ((latitude == null) ? 0 : latitude.hashCode());
        result = prime * result + ((logoUrl == null) ? 0 : logoUrl.hashCode());
        result = prime * result
                + ((logoVersion == null) ? 0 : logoVersion.hashCode());
        result = prime * result
                + ((longitude == null) ? 0 : longitude.hashCode());
        result = prime * result
                + ((restaurantName == null) ? 0 : restaurantName.hashCode());
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
        RestaurantInfo other = (RestaurantInfo) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
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
        if (restaurantName == null) {
            if (other.restaurantName != null)
                return false;
        } else if (!restaurantName.equals(other.restaurantName))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "RestaurantInfo [restaurantName=" + restaurantName
                + ", latitude=" + latitude + ", longitude=" + longitude
                + ", logoVersion=" + logoVersion + ", logoUrl=" + logoUrl
                + ", address=" + address + ", favorites=" + favorites
                + ", followers=" + followers + "]";
    }
}