/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impetussports.dbobjects;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Michael Orner
 */

@Entity
public class User implements Serializable {
    
    @Id
    private String username;
    private String usertype;
    private String firstname;
    private String lastname;
    private String password;
    private String age;
    private String birthdate;
    private String weight;
    private String hieght;
    
    @OneToMany(mappedBy = "user")
    private List<Workout> workouts;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
