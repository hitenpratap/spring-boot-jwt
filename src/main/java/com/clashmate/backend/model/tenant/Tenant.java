package com.clashmate.backend.model.tenant;

import com.clashmate.backend.commandObjects.tenant.TenantCO;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "tenants")
public class Tenant {

    @Id
    private String id;
    private String name;
    private String address;
    @Indexed(direction = IndexDirection.DESCENDING, dropDups = true, sparse = true)
    private String domainName;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String secondaryDomainName;
    @CreatedDate
    private Date dateCreated;
    @LastModifiedDate
    private Date lastUpdated;
    private String uniqueId;
    private String phoneNumber;
    private String emailAddress;

    public Tenant() {
    }

    public Tenant(TenantCO tenantCO) {
        this.name = tenantCO.getName();
        this.secondaryDomainName = tenantCO.getSecondaryDomainName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
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
