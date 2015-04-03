package io.tasteit.rest.service.model;

public class Address {

    private String localAddressLineOne;
    private String localAddressLineTwo;
    private String city;
    private String zipCode;
    private String state;
    private String country;
    
    public String getLocalAddressLineOne() {
        return localAddressLineOne;
    }
    
    public String getLocalAddressLineTwo() {
        return localAddressLineTwo;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getZipCode() {
        return zipCode;
    }
    
    public String getState() {
        return state;
    }
    
    public String getCountry() {
        return country;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime
                * result
                + ((localAddressLineOne == null) ? 0 : localAddressLineOne
                        .hashCode());
        result = prime
                * result
                + ((localAddressLineTwo == null) ? 0 : localAddressLineTwo
                        .hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
        Address other = (Address) obj;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (localAddressLineOne == null) {
            if (other.localAddressLineOne != null)
                return false;
        } else if (!localAddressLineOne.equals(other.localAddressLineOne))
            return false;
        if (localAddressLineTwo == null) {
            if (other.localAddressLineTwo != null)
                return false;
        } else if (!localAddressLineTwo.equals(other.localAddressLineTwo))
            return false;
        if (state == null) {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
            return false;
        if (zipCode == null) {
            if (other.zipCode != null)
                return false;
        } else if (!zipCode.equals(other.zipCode))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Address [localAddressLineOne=" + localAddressLineOne
                + ", localAddressLineTwo=" + localAddressLineTwo + ", city="
                + city + ", zipCode=" + zipCode + ", state=" + state
                + ", country=" + country + "]";
    }
}
