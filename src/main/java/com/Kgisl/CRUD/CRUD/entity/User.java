package com.Kgisl.CRUD.CRUD.entity;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 
/**
 * Team
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
 
    private String username;
    
  
 
    /**
     * @return the userId
     */
    public Long getUserid() {
        return userid;
    }
 
    /**
     * @param userid the userId to set
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }
 
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }
 
    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
}