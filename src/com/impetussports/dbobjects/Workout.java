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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Michael Orner
 */
 
// workout contains multiple exercises, tonnage, workoutGoals, totalDistanceTraveled

@Entity
public class Workout implements Serializable {
    @Id
    private String date;
    private double tonnage;
    private double totalDistanceTravel;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    
    @OneToMany(mappedBy = "workout")
    private List<Exercise> exercises;
}
