package io.tasteit.rest.service.model.request;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;

public class UpdateCuisineRequest {
    
    @Nonnull private String cuisineId;
    @Nullable private String cuisineName;
    @Nullable private String cuisineDesc;
    @Nullable private String cuisineCategory;
    @Nullable private String cuisineType;
    @Nullable private List<String> mealTypes;
    @Nullable private Boolean vegetarian;
    @Nullable private Boolean glutenFree;
    @Nullable private String menuCategory;
    @Nullable private Float price;
    
    public UpdateCuisineRequest(@Nonnull String cuisineId) {
        if (StringUtils.isBlank(cuisineId)) {
            throw new IllegalArgumentException("cuisineId should not be null or empty");
        }
        this.cuisineId = cuisineId;
    }

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

    public String getMenuCategory() {
        return menuCategory;
    }

    public void setMenuCategory(String menuCategory) {
        this.menuCategory = menuCategory;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
