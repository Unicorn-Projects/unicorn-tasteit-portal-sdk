package io.tasteit.rest.service.model.response;

import io.tasteit.rest.service.model.AuthenticationToken;

import java.util.Date;

public class GenerateTokenResponse {

    private String tokenType;
    private String accessToken;
    private Date expireAt;
    private Long principal;
    
    public String getTokenType() {
        return tokenType;
    }
    public String getAccessToken() {
        return accessToken;
    }
    public Date getExpireAt() {
        return expireAt;
    }
    public Long getPrincipal() {
        return principal;
    }
    
    public AuthenticationToken buildAuthorizationToken() {
        
        AuthenticationToken token = new AuthenticationToken();
        token.setTokenType(tokenType);
        token.setToken(accessToken);
        token.setExpireAt(expireAt);
        token.setPrincipal(principal);
        
        return token;
    }
    
    
    @Override
    public String toString() {
        return "GenerateTokenResponse [tokenType=" + tokenType
                + ", accessToken=" + accessToken + ", expireAt=" + expireAt
                + ", principal=" + principal + "]";
    }
}