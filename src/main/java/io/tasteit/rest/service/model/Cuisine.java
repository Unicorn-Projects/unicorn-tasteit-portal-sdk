package io.tasteit.rest.service.model;

import java.util.List;

public class Cuisine {

    private String cuisineId;
    private String cuisineName;
    private String cuisineDesc;
    private String cuisineCategory;
    private String cuisineType;
    private List<String> mealTypes;
    private String menuCategory;
    private Boolean vegetarian;
    private Boolean glutenFree;
    private Integer imageVersion;
    private String imageUrl;
    private Float imageRatio;
    private Float price;
    private Boolean unavailable;
    private Long favorites;
    
    public String getCuisineId() {
        return cuisineId;
    }

    public String getCuisineName() {
        return cuisineName;
    }
    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }
    public String getCuisineDesc() {
        return cuisineDesc;
    }
    public void setCuisineDesc(String cuisineDesc) {
        this.cuisineDesc = cuisineDesc;
    }
    public String getCuisineCategory() {
        return cuisineCategory;
    }
    public void setCuisineCategory(String cuisineCategory) {
        this.cuisineCategory = cuisineCategory;
    }
    public String getCuisineType() {
        return cuisineType;
    }
    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }
    public List<String> getMealTypes() {
        return mealTypes;
    }
    public void setMealTypes(List<String> mealTypes) {
        this.mealTypes = mealTypes;
    }
    public String getMenuCategory() {
        return menuCategory;
    }
    public void setMenuCategory(String menuCategory) {
        this.menuCategory = menuCategory;
    }
    public Boolean getVegetarian() {
        return vegetarian;
    }
    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }
    public Boolean getGlutenFree() {
        return glutenFree;
    }
    public void setGlutenFree(Boolean glutenFree) {
        this.glutenFree = glutenFree;
    }
    public Integer getImageVersion() {
        return imageVersion;
    }
    public void setImageVersion(Integer imageVersion) {
        this.imageVersion = imageVersion;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public Float getImageRatio() {
        return imageRatio;
    }
    public void setImageRatio(Float imageRatio) {
        this.imageRatio = imageRatio;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public Boolean getUnavailable() {
        return unavailable;
    }
    public void setUnavailable(Boolean unavailable) {
        this.unavailable = unavailable;
    }
    public Long getFavorites() {
        return favorites;
    }
    public void setFavorites(Long favorites) {
        this.favorites = favorites;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((cuisineCategory == null) ? 0 : cuisineCategory.hashCode());
        result = prime * result
                + ((cuisineDesc == null) ? 0 : cuisineDesc.hashCode());
        result = prime * result
                + ((cuisineId == null) ? 0 : cuisineId.hashCode());
        result = prime * result
                + ((cuisineName == null) ? 0 : cuisineName.hashCode());
        result = prime * result
                + ((cuisineType == null) ? 0 : cuisineType.hashCode());
        result = prime * result
                + ((favorites == null) ? 0 : favorites.hashCode());
        result = prime * result
                + ((glutenFree == null) ? 0 : glutenFree.hashCode());
        result = prime * result
                + ((imageRatio == null) ? 0 : imageRatio.hashCode());
        result = prime * result
                + ((imageUrl == null) ? 0 : imageUrl.hashCode());
        result = prime * result
                + ((imageVersion == null) ? 0 : imageVersion.hashCode());
        result = prime * result
                + ((mealTypes == null) ? 0 : mealTypes.hashCode());
        result = prime * result
                + ((menuCategory == null) ? 0 : menuCategory.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result
                + ((unavailable == null) ? 0 : unavailable.hashCode());
        result = prime * result
                + ((vegetarian == null) ? 0 : vegetarian.hashCode());
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
        Cuisine other = (Cuisine) obj;
        if (cuisineCategory == null) {
            if (other.cuisineCategory != null)
                return false;
        } else if (!cuisineCategory.equals(other.cuisineCategory))
            return false;
        if (cuisineDesc == null) {
            if (other.cuisineDesc != null)
                return false;
        } else if (!cuisineDesc.equals(other.cuisineDesc))
            return false;
        if (cuisineId == null) {
            if (other.cuisineId != null)
                return false;
        } else if (!cuisineId.equals(other.cuisineId))
            return false;
        if (cuisineName == null) {
            if (other.cuisineName != null)
                return false;
        } else if (!cuisineName.equals(other.cuisineName))
            return false;
        if (cuisineType == null) {
            if (other.cuisineType != null)
                return false;
        } else if (!cuisineType.equals(other.cuisineType))
            return false;
        if (favorites == null) {
            if (other.favorites != null)
                return false;
        } else if (!favorites.equals(other.favorites))
            return false;
        if (glutenFree == null) {
            if (other.glutenFree != null)
                return false;
        } else if (!glutenFree.equals(other.glutenFree))
            return false;
        if (imageRatio == null) {
            if (other.imageRatio != null)
                return false;
        } else if (!imageRatio.equals(other.imageRatio))
            return false;
        if (imageUrl == null) {
            if (other.imageUrl != null)
                return false;
        } else if (!imageUrl.equals(other.imageUrl))
            return false;
        if (imageVersion == null) {
            if (other.imageVersion != null)
                return false;
        } else if (!imageVersion.equals(other.imageVersion))
            return false;
        if (mealTypes == null) {
            if (other.mealTypes != null)
                return false;
        } else if (!mealTypes.equals(other.mealTypes))
            return false;
        if (menuCategory == null) {
            if (other.menuCategory != null)
                return false;
        } else if (!menuCategory.equals(other.menuCategory))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (unavailable == null) {
            if (other.unavailable != null)
                return false;
        } else if (!unavailable.equals(other.unavailable))
            return false;
        if (vegetarian == null) {
            if (other.vegetarian != null)
                return false;
        } else if (!vegetarian.equals(other.vegetarian))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "Cuisine [cuisineId=" + cuisineId + ", cuisineName="
                + cuisineName + ", cuisineDesc=" + cuisineDesc
                + ", cuisineCategory=" + cuisineCategory + ", cuisineType="
                + cuisineType + ", mealTypes=" + mealTypes + ", menuCategory="
                + menuCategory + ", vegetarian=" + vegetarian + ", glutenFree="
                + glutenFree + ", imageVersion=" + imageVersion + ", imageUrl="
                + imageUrl + ", imageRatio=" + imageRatio + ", price=" + price
                + ", unavailable=" + unavailable + ", favorites=" + favorites
                + "]";
    }
}
