package io.tasteit.rest.service.model.response;

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
    
}