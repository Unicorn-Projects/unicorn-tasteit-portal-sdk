package io.tasteit.rest.service.model;

import java.util.Date;

public class AuthenticationToken {

    private String tokenType;
    private String token;
    private Date expireAt;
    private Long principal;
    
    public String getTokenType() {
        return tokenType;
    }
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public Date getExpireAt() {
        return expireAt;
    }
    public void setExpireAt(Date expireAt) {
        this.expireAt = expireAt;
    }
    public Long getPrincipal() {
        return principal;
    }
    public void setPrincipal(Long principal) {
        this.principal = principal;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((expireAt == null) ? 0 : expireAt.hashCode());
        result = prime * result
                + ((principal == null) ? 0 : principal.hashCode());
        result = prime * result + ((token == null) ? 0 : token.hashCode());
        result = prime * result
                + ((tokenType == null) ? 0 : tokenType.hashCode());
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
        AuthenticationToken other = (AuthenticationToken) obj;
        if (expireAt == null) {
            if (other.expireAt != null)
                return false;
        } else if (!expireAt.equals(other.expireAt))
            return false;
        if (principal == null) {
            if (other.principal != null)
                return false;
        } else if (!principal.equals(other.principal))
            return false;
        if (token == null) {
            if (other.token != null)
                return false;
        } else if (!token.equals(other.token))
            return false;
        if (tokenType == null) {
            if (other.tokenType != null)
                return false;
        } else if (!tokenType.equals(other.tokenType))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "AuthorizationToken [tokenType=" + tokenType + ", expireAt="
                + expireAt + ", principal=" + principal + "]";
    }
}
