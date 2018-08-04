package com.clashmate.backend.commandObjects.tenant;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TenantCO {

    @NotBlank
    private String name;
    private String domainName;
    @NotBlank
    private String secondaryDomainName;
    private String address;
    @Size(min = 10, max = 10)
    private String phoneNumber;
    @Email
    private String emailAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getSecondaryDomainName() {
        return secondaryDomainName;
    }

    public void setSecondaryDomainName(String secondaryDomainName) {
        this.secondaryDomainName = secondaryDomainName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
