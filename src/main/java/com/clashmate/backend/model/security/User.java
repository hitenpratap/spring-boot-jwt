package com.clashmate.backend.model.security;

import com.clashmate.backend.dto.auth.SignupDTO;
import com.clashmate.backend.repository.UserRoleRepository;
import com.clashmate.backend.services.BeanUtil;
import com.clashmate.backend.util.HelperMethod;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Document(collection = "users")
public abstract class User {

    @Id
    private String id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String emailAddress;
    @Indexed(sparse = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String phoneNumber;
    private String password;
    private String uniqueId;
    @CreatedDate
    private Date dateCreated;
    @LastModifiedDate
    private Date lastUpdated;

    public User() {
    }

    public User(SignupDTO signupDTO) {
        this.emailAddress = signupDTO.getEmailAddress();
        this.phoneNumber = signupDTO.getPhoneNumber();
        HelperMethod helperMethod = BeanUtil.getBean(HelperMethod.class);
        this.uniqueId = helperMethod.fetchRandomUniqueStr();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return this.emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        UserRoleRepository userRoleRepository = BeanUtil.getBean(UserRoleRepository.class);
        Iterable<UserRole> userRoleIterable = userRoleRepository.findAllByUser(this);
        List<UserRole> userRoleList = new ArrayList<>();
        userRoleIterable.forEach(userRoleList::add);
        return userRoleList.stream().map(UserRole::getRole).collect(Collectors.toList());
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
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
}
