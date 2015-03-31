package io.tasteit.rest.service.model;

import java.util.List;

public class RestaurantDetail {

    private List<String> imagesUrls;
    private Address address;
    private String contact;
    private String website;
    
    public RestaurantDetail() {}

    public List<String> getImagesUrls() {
        return imagesUrls;
    }
    public void setImagesUrls(List<String> imagesUrls) {
        this.imagesUrls = imagesUrls;
    }
    public Address getAddress() {
        return address;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((contact == null) ? 0 : contact.hashCode());
        result = prime * result
                + ((imagesUrls == null) ? 0 : imagesUrls.hashCode());
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
        RestaurantDetail other = (RestaurantDetail) obj;
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
        if (imagesUrls == null) {
            if (other.imagesUrls != null)
                return false;
        } else if (!imagesUrls.equals(other.imagesUrls))
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
        return "RestaurantDetail [imagesUrls=" + imagesUrls + ", address="
                + address + ", contact=" + contact + ", website=" + website
                + "]";
    }
}