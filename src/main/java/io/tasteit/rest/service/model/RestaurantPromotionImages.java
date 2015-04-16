package io.tasteit.rest.service.model;

import java.util.List;

public class RestaurantPromotionImages {
   
    private List<Integer> displayImages;
    private List<String> displayImagesUrls;
    private List<Integer> imagesRepo;
    private List<String> imagesRepoUrls;
    
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
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((displayImages == null) ? 0 : displayImages.hashCode());
        result = prime
                * result
                + ((displayImagesUrls == null) ? 0 : displayImagesUrls
                        .hashCode());
        result = prime * result
                + ((imagesRepo == null) ? 0 : imagesRepo.hashCode());
        result = prime * result
                + ((imagesRepoUrls == null) ? 0 : imagesRepoUrls.hashCode());
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
        RestaurantPromotionImages other = (RestaurantPromotionImages) obj;
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
        return true;
    }
    
    @Override
    public String toString() {
        return "RestaurantPromotionImages [displayImages=" + displayImages
                + ", displayImagesUrls=" + displayImagesUrls + ", imagesRepo="
                + imagesRepo + ", imagesRepoUrls=" + imagesRepoUrls + "]";
    }
}
