package com.dbs.hibernate.HIbernateDemo.model;

import java.io.Serializable;
import java.util.Set;

public class ReaderEntity implements Serializable {
 
    private static final long serialVersionUID = -1798070786993154676L;
 
    private Integer readerId;
 
    private String email;
 
    private String firstName;
 
    private String lastName;
 
    private Set<SubscriptionEntity> subscriptions;
 
    public Integer getReaderId() {
        return readerId;
    }
 
    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public Set<SubscriptionEntity> getSubscriptions() {
        return subscriptions;
    }
 
    public void setSubscriptions(Set<SubscriptionEntity> subscriptions) {
        this.subscriptions = subscriptions;
    }}
