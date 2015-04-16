package io.tasteit.rest.service.model.request;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.StringUtils;

public class RevokeTokenRequest {

    public static final String TOKEN_TYPE = "token_type";
    public static final String TOKEN = "token";
    public static final String PRINCIPAL = "principal";

    @Nonnull private String tokenType;
    @Nonnull private String token;
    @Nonnull private Long principal;

    public RevokeTokenRequest(String tokenType, String token, Long principal) {
        if (StringUtils.isBlank(tokenType) || StringUtils.isBlank(token) || principal == null) {
            throw new IllegalArgumentException("tokenType and token and principal should not be null or empty");
        }

        this.tokenType = tokenType;
        this.token = token;
        this.principal = principal;
    }

    public @Nonnull String getTokenType() {
        return tokenType;
    }

    public @Nonnull String getToken() {
        return token;
    }

    public @Nonnull Long getPrincipal() {
        return principal;
    }
}