package io.tasteit.rest.service.model.request;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.StringUtils;

public class GenerateTokenRequest {

    @Nonnull private String grantType = "customer_credential";
    @Nonnull private final String loginName;
    @Nonnull private final String credential;
    
    public GenerateTokenRequest(String loginName, String credential) {
        if (StringUtils.isBlank(loginName) || StringUtils.isBlank(credential)) {
            throw new IllegalArgumentException("loginName and credential should not be null or empty");
        }
        this.loginName = loginName;
        this.credential = credential;
    }

    public @Nonnull String getGrantType() {
        return grantType;
    }
    
    public @Nonnull String getLoginName() {
        return loginName;
    }

    public @Nonnull String getCredential() {
        return credential;
    }
}