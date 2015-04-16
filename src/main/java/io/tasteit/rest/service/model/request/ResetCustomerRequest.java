package io.tasteit.rest.service.model.request;

import javax.annotation.Nonnull;

public class ResetCustomerRequest {
    @Nonnull private String token;
    @Nonnull private String emailAddress;
    @Nonnull private Long customerPrincipal;
    @Nonnull private String credential;

    public ResetCustomerRequest(String token, String emailAddress, Long customerPrincipal, String credential) {
        super();
        this.token = token;
        this.emailAddress = emailAddress;
        this.customerPrincipal = customerPrincipal;
        this.credential = credential;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public Long getCustomerPrincipal() {
        return customerPrincipal;
    }
    public void setCustomerPrincipal(Long customerPrincipal) {
        this.customerPrincipal = customerPrincipal;
    }
    public String getCredential() {
        return credential;
    }
    public void setCredential(String credential) {
        this.credential = credential;
    }
}
